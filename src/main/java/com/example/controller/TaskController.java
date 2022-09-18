package com.example.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Task;
import com.example.service.TaskService;



@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Task> t= service.getAllTask();
		m.addAttribute("t",t);
		return "index";
	}
	
	@GetMapping("/addtask")
	public String addTaskForm() {
		
		return "add_task";
		
	}
	
	
	
	@PostMapping("/register")
	public String taskRegister(@ModelAttribute Task task,HttpSession session) {
		System.out.println(task);
		
		service.addTask(task);
		session.setAttribute("msg", "Employee added successfully.. ");
		
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Task t=service.getTaskById(id);
		m.addAttribute("t",t);
		return "edit";
	}
	@PostMapping("/update")
	public String updateTask(@ModelAttribute Task t,HttpSession session) {
		
		service.addTask(t);
		session.setAttribute("msg", "Task Update Successfully...");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable int id,HttpSession session) {
		
		
		service.deleteTask(id);
		session.setAttribute("msg", "Task Delete Successfully...");
		return "redirect:/";
		
	}
	
}