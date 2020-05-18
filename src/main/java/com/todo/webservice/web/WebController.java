package com.todo.webservice.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo.webservice.domain.Todo.TODO;
import com.todo.webservice.domain.Todo.TODORepository;
import com.todo.webservice.service.PostsService;

import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class WebController {
		
	private PostsService postsService;
	private TODORepository todoRepository;
	
	@GetMapping("/main")
	public String main(Model model) {
		List<TODO> todoList = todoRepository.findAll();
		model.addAttribute("todoList", todoList);
		return "main";
	}
}
