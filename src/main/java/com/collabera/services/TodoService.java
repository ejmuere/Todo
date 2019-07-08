package com.collabera.services;

import java.util.List;

import java.util.ArrayList;
import java.util.Date;

import com.collabera.models.*;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	//Create
	//Add
	//Delete
	//Update
	
	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int id = 5;
	
	static {
		todoList.add(new Todo(1,"root", "wow amazing", false, new Date()));
		todoList.add(new Todo(2,"groot", "i am groot", true, new Date()));
		todoList.add(new Todo(3,"root", "im trash", false, new Date()));
		todoList.add(new Todo(4,"row", "row row row  your boat", false, new Date()));
		todoList.add(new Todo(5,"root", "roasting and toasting", true, new Date()));
	}
	
	public List<Todo> listTodo(String username){
		List<Todo> tempTodo = new ArrayList<Todo>();
		for(Todo t: todoList) {
			if(t.getUser().equals(username))
				tempTodo.add(t);
		}
		
//		List<TodoModels> tempTodo = new ArrayList<TodoModels>();
//		tempTodo.removeIf(user -> !user.getUser().equals(username));
		return tempTodo;
		
	}
	
	public List<Todo> getTodos(){
		return todoList;
	}
	
	public void addTodo(String name, String description, boolean isDone, Date targetDate){
		todoList.add(new Todo(++id,name,description,isDone, targetDate));
	}
	
	public void deleteTodo(int id) {
		todoList.removeIf(user -> user.getId()==id);
	}
	
	public Todo getTodo(int id) {
		for(Todo t: todoList) {
			if(t.getId()==id)
				return t;	
		}
		return null;
	}
	
	public void updateTodo(int id, String description,boolean done, Date date) {
		for(Todo t: todoList)
			if(id == t.getId()) {
				t.setDescription(description);
				t.setDone(done);
			    //t.setTargetDate(date);
			}
	}
	
	

}
