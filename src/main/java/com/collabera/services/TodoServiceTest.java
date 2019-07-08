package com.collabera.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.databases.TodoRepository;
import com.collabera.exceptions.TodoNotFoundException;
import com.collabera.models.Todo;

@Service
public class TodoServiceTest {
	@Autowired
	TodoRepository todoRepository;
	
	private static int id = 1;
	
	public Todo getTodo(int id) {
		Optional<Todo> t = todoRepository.findById(id);
		if(t.isPresent())
			return t.get();
		else
			throw new TodoNotFoundException(String.format("Todo %s not found", id));
		}
	public List<Todo> getTodos(){
		return todoRepository.findAll();
	}
	
	public List<Todo> listTodo(String user){
		return todoRepository.findByUser(user);
	}
	
	public Optional<Todo> getTodosById(int id){
		return todoRepository.findById(id);
	}
	
	public Todo addTodo(String user, String description, boolean done, Date targetDate) {
		Todo todo = new Todo(id++,user,description,done,targetDate);
		return todoRepository.save(todo);
	}

	public void deleteTodo(int id) {
		Optional<Todo> t = todoRepository.findById(id);
		if(t.isPresent())
			todoRepository.delete(t.get());
	}
	
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}
}
