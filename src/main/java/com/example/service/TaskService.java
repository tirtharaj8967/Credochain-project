package com.example.service;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.stereotype.Service;

	import com.example.entity.Task;
	import com.example.repository.TaskRepo;


	@Service
	public class TaskService {
		@Autowired
		private TaskRepo repo;
		
		public void addTask(Task task) {
			
			repo.save(task);
			
		}
		
		public List<Task> getAllTask(){
			
			return repo.findAll();
			
		}
		
		public Task getTaskById(int id) {
			 
			Optional<Task> t =  repo.findById(id);
			if(t.isPresent()) {
				return t.get();
			}
			return null;
		}
		
		public void deleteTask(int id) {
			repo.deleteById(id);
		}

}
