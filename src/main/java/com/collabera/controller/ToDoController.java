package com.collabera.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collabera.models.Todo;
import com.collabera.models.Users;
import com.collabera.services.TodoService;
import com.collabera.services.TodoServiceTest;

@Controller
@SessionAttributes("username")
public class ToDoController {
	
	//list todo
	//add todo
	//delete todo
	@Autowired
	TodoServiceTest service;
	@RequestMapping(value = "/listtodos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {
		String username = getLoginUserName(model);
		model.put("todos", service.listTodo(username));
		return "listtodo";
	}
	@RequestMapping(value = "/addtodos", method = RequestMethod.GET)
	public String showaddTodos() {
		return "addtodo";
	}
	@RequestMapping(value = "/addtodos", method = RequestMethod.POST)
	public String addTodos(ModelMap model,@ModelAttribute("todo") @Valid Todo todo, BindingResult result) {
		if(result.hasErrors())
			return "addtodo";
		String username = getLoginUserName(model);
		service.addTodo(username,todo.getDescription(),todo.getDone(),new Date());
		return "redirect:/listtodos";
	}
	@RequestMapping(value = "/deletetodos", method = RequestMethod.GET)
	public String listTodos(ModelMap model, @RequestParam String todoId) {
		int id = Integer.parseInt(todoId);
		service.deleteTodo(id);
		return "redirect:/listtodos";
	}
	
	@RequestMapping(value = "/updatetodos", method = RequestMethod.GET)
	public String showupdateTodos(ModelMap model,@RequestParam String todoId) {
			int id = Integer.parseInt(todoId);
			Todo todo = service.getTodo(id);
			model.put("todo", todo);
			System.out.println(todo.getId());
			return "updatetodo";
	}
	@RequestMapping(value = "/updatetodos", method = RequestMethod.POST)
	public String updateTodos(ModelMap model,@ModelAttribute("todo")  @Valid Todo todo, BindingResult result) {	
		if(result.hasErrors())
			return "updateTodo";
		service.updateTodo(todo);
		return "redirect:/listtodos";
	}
		
	private String getLoginUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		return principal.toString();
	}
	
}
