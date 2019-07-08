package com.collabera.databases;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.collabera.models.Todo;
import com.collabera.services.TodoService;
import com.collabera.services.TodoServiceTest;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.collabera.databases"})
@EntityScan(basePackages= {"com.collabera.models"})
@Component
public class TodoCommandLineRunner implements CommandLineRunner {

	@Autowired
	TodoServiceTest service;
	
	@Override
	public void run(String... args) throws Exception {
		
		service.addTodo("orie", "Laundry", false, new Date());
		service.addTodo("orie", "Shopping", false, new Date());
		service.addTodo("root", "Play Games", true, new Date());
		service.addTodo("root", "Buy Dinner", true, new Date());
		
		List<Todo> todosList = service.getTodos();
		System.out.println("All Todos:\n" + todosList + "\n");
		
		todosList = service.listTodo("root");
		System.out.println("All Todos by root:\n" + todosList + "\n");
		
		Todo todosList2 = service.getTodo(1);
		System.out.println("Todo of id 1: " + todosList2 + "\n");
		
		todosList2 = service.getTodo(1);
		System.out.println("Todo of id 1: " + todosList2 + "\n");
		
	}

}