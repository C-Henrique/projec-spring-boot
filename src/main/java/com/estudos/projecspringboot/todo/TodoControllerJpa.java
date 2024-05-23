package com.estudos.projecspringboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	private TodoService todoService;
	private TodoRepository todoRepository;
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		this.todoService = todoService;
		this.todoRepository = todoRepository;

	}

	@GetMapping("list-todo")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);

		List<Todo> list = todoRepository.findByUsername(username);
		model.put("todos", list);
		return "listTodos";

	}

	private String getLoggedInUsername(ModelMap model) {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@GetMapping("add-todo")
	public String showNewTodo(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}

	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = getLoggedInUsername(model);
		todoService.addTodos(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";
	}

	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {

		todoService.deleteById(id);
		return "redirect:list-todo";

	}

	@GetMapping("update-todo")
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {

		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "addTodo";

	}

	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = model.get("name").toString();
		todo.setUsername(username);

		todoService.updateTodo(todo);
		return "redirect:list-todo";
	}
}
