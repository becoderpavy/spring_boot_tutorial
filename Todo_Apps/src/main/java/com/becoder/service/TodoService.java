package com.becoder.service;

import java.util.List;

import com.becoder.entites.Todo;

public interface TodoService {

	public Todo saveTodo(Todo todo);

	public List<Todo> getAllTodo();

	public Todo getByid(int id);

	public void delete(int id);

	public Todo updateTodo(int id, Todo todo);

}
