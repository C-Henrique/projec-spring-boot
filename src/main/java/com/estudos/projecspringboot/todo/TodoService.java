package com.estudos.projecspringboot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static int todosCount = 0;

	private static List<Todo> todos = new ArrayList<Todo>();

	static {
		todos.add(new Todo(++todosCount, "admin", "teste lista", LocalDate.now().plusYears(1), Boolean.FALSE));
		todos.add(new Todo(++todosCount, "admin", "teste lista II", LocalDate.now().plusYears(2), Boolean.FALSE));
	}

	public List<Todo> findByUsername(String username) {

		return todos.stream().filter(t -> t.getUsername().equalsIgnoreCase(username)).toList();
	}

	public void addTodos(String username, String description, LocalDate targetDate, Boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		todos.removeIf(t -> t.getId() == id);

	}

	public Todo findById(int id) {
		return todos.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
