package com.tao.taskshedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tao.taskshedule.entity.Task;
import com.tao.taskshedule.model.DatesDto;
import com.tao.taskshedule.model.StatisticsDto;
import com.tao.taskshedule.model.TaskAssignDto;
import com.tao.taskshedule.model.TaskDto;
import com.tao.taskshedule.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskSheduleController {
	
@Autowired
  private TaskService taskService;
	 

	 @PostMapping("/")
	    public ResponseEntity<Task> createTask(@RequestBody TaskDto task) {
		 System.out.println(task.getDescription());
	        return ResponseEntity.ok(taskService.createTask(task));
	    }
	 
	    @GetMapping("/")
	    public ResponseEntity<List<Task>> getAllTasks() {
	        return ResponseEntity.ok(taskService.getAllTask());
	    }

	    @DeleteMapping("/{taskid}")
	    public ResponseEntity<Boolean> deleteById(@PathVariable Long taskid) {
	        taskService.deleteById(taskid);
	        return ResponseEntity.ok(true);
	    }
	    
	    @PutMapping("/{taskid}")
	    public ResponseEntity<Task> updateTask(@PathVariable Long taskid, @RequestBody TaskDto task) {
	    	        return ResponseEntity.ok(taskService.updateTask(taskid,task));
	    }

	    @PutMapping("/{taskid}/progress")
	    public ResponseEntity<Task> updateTaskProgress(@PathVariable Long taskid, @RequestBody TaskDto task) {
	    	        return ResponseEntity.ok(taskService.updateTaskProgress(taskid,task));
	    }
	    
	    @GetMapping("/status/{status}")
	    public ResponseEntity<List<Task>> getTasksbystatus(@PathVariable String status) {
	    	        return ResponseEntity.ok(taskService.getTasksbystatus(status));
	    }
	    
	    @GetMapping("/overdue")
	    public ResponseEntity<List<Task>> getOverduedTasks() {
	        return ResponseEntity.ok(taskService.getOverduedTasks());
	    }
	    @GetMapping("/statistics")
	    public ResponseEntity<StatisticsDto> getStatistics() {
	        return ResponseEntity.ok(taskService.getStatistics());
	    }
	    @GetMapping("/completed")
	    public ResponseEntity<List<Task>> getTasksCompleted( @RequestBody DatesDto datesDto) {
	        return ResponseEntity.ok(taskService.getTasksCompleted(datesDto));
	    }
	    
	    @PutMapping("/{taskid}/assign")
	    public ResponseEntity<Task> assignTask(@PathVariable Long taskid, @RequestBody TaskAssignDto taskAssignDto) {
	        return ResponseEntity.ok(taskService.assignTask(taskid,taskAssignDto));
	    }
	    
	    @GetMapping("/{userid}/tasks")
	    public ResponseEntity<List<Task>> getTasksbyUserid(@PathVariable Long userid) {
	    	        return ResponseEntity.ok(taskService.getTasksbyUserid(userid));
	    }
	    
	    @GetMapping("/priorityQueue")
	    public ResponseEntity<List<Task>> getTasksPriorityQueue() {
	    	        return ResponseEntity.ok(taskService.getTasksPriorityQueue());
	    }
	    
}
