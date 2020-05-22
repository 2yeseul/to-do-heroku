package com.todo.webservice.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.webservice.domain.Todo.TODO;
import com.todo.webservice.domain.Todo.TODORepository;
import com.todo.webservice.dto.posts.PostsMainResponseDto;
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
		int size = todoList.size();
		if(size>0) {
			Long nextId = todoList.get(size-1).getId()+1;
			model.addAttribute("nextId", nextId);
		}
		model.addAttribute("todoList", todoList);
		return "main";
	}
	
	@GetMapping("/active")
	public String active(Model model) {
		List<PostsMainResponseDto> todoList = postsService.findActive();
		int size = todoList.size();
		if(size>0) {
			Long nextId = todoList.get(size-1).getId()+1;
			model.addAttribute("nextId", nextId);
		}
		model.addAttribute("todoList", todoList);
		return "main";
	}
	
	@GetMapping("/done")
	public String done(Model model) {
		List<PostsMainResponseDto> todoList = postsService.findDone();
		int size = todoList.size();
		if(size>0) {
			Long nextId = todoList.get(size-1).getId()+1;
			model.addAttribute("nextId", nextId);
		}
		model.addAttribute("todoList", todoList);
		return "main";
	}
}
