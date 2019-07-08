package com.collabera.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import com.collabera.models.Users;
import com.collabera.services.UserService;

@Controller
@SessionAttributes("username")
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityContextHolder.getContext().getAuthentication();
		return "redirect:/login";
	}
	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public String listusers(ModelMap model) {
		model.put("users", service.listUsers());
		return "users";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showsignup() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addUser(ModelMap model,@ModelAttribute("user") @Valid Users user, BindingResult result) {
		if(result.hasErrors())
			return "signup";
		if(service.validUserName(user.getUsername())) {
		service.addUser(user.getUsername(),user.getPassword(),user.getEmail());
		SecurityContextHolder.getContext().getAuthentication();
		return "redirect:/login";
		}
		else {
			model.put("errorMessage", "Username found try again");
			return "signup";
		}
	}
	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public String listUser(ModelMap model, @RequestParam int userId) {
		service.deleteUser(userId);
		return "redirect:/listusers";
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	public String showupdateUser(ModelMap model,@RequestParam int userId) {
			Users user = service.getUser(userId);
			model.put("user", user);
			return "updateuser";
	}
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateTodos(ModelMap model,@ModelAttribute("user")  @Valid Users user, BindingResult result) {	
		if(result.hasErrors())
			return "updateuser";
		service.updateUser(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
		return "redirect:/listusers";
	}
	
//	@Bean
//	private String getLoginUserName(ModelMap model) {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(principal instanceof UserDetails)
//			return ((UserDetails) principal).getUsername();
//		return principal.toString();
//	}

}
