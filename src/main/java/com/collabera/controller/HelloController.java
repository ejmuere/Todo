package com.collabera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collabera.services.LoginService;

@Controller
public class HelloController {
	@Autowired
	LoginService loginServ;
	@RequestMapping(value = "/hello")
	public String helloMessage() {
		return "hello";
	}
}
