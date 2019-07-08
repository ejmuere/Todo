package com.collabera.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collabera.models.Users;
import com.collabera.services.TodoService;
import com.collabera.services.TodoServiceTest;
import com.collabera.services.UserService;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	UserService useServ;
	
	@Autowired
	TodoServiceTest service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(ModelMap model,@ModelAttribute("user") @Valid Users user,BindingResult result) {
		if(result.hasErrors())
			return "login";
		if(useServ.isValidUser(user.getUsername(),user.getPassword())) {
		model.put("username", user.getUsername());
		model.put("password", user.getPassword());
		return "hello";
		}
		else {
			model.put("error", "Wrong username or password try again");
			return "login";
		}

	}

}
