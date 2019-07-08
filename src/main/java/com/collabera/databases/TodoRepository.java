package com.collabera.databases;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
	
	List<Todo> findByUser(String username);

}
