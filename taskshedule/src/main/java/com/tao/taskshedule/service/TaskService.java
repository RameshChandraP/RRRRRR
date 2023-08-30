package com.tao.taskshedule.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tao.taskshedule.dao.TaskRepository;
import com.tao.taskshedule.dao.UserRepository;
import com.tao.taskshedule.entity.Task;
import com.tao.taskshedule.entity.User;
import com.tao.taskshedule.model.DatesDto;
import com.tao.taskshedule.model.StatisticsDto;
import com.tao.taskshedule.model.TaskAssignDto;
import com.tao.taskshedule.model.TaskDto;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	

	public Task createTask(TaskDto taskdto) {
		
		Task task = new Task();
		BeanUtils.copyProperties(taskdto, task);
		
		return taskRepository.save(task);
	}
	
		
	public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

	
	public void deleteById(Long taskid) {
        taskRepository.deleteById(taskid);
    }
	//convert below code Optional java8 and throw exception
	@SuppressWarnings("deprecation")
	public Task updateTask(Long taskid, TaskDto taskdto) {
		Task task = taskRepository.getOne(taskid);
		task.setStatus(taskdto.getStatus());
		 if(taskdto.getStatus().equalsIgnoreCase("completed")) {
			  
		
			task.setEnddate(new Date());
		
		 }
		task.setDuedate(taskdto.getDuedate());
		return taskRepository.save(task);
    }
	@SuppressWarnings("deprecation")
	public Task updateTaskProgress(Long taskid, TaskDto taskdto) {
		Task task = taskRepository.getOne(taskid);
		task.setProgresspercentage(taskdto.getProgresspercentage());
        return taskRepository.save(task);
    }
	
	 public List<Task> getTasksbystatus(String status) {
		 return taskRepository.findByStatus(status);
	 }
	
	 public List<Task> getOverduedTasks() {
		 List<Task>  listTask=   getAllTask();
		List<Task> overduedList = 
				 listTask
				     .stream()
				     .filter(
				               p -> p.getDuedate().before(new Date())
				    ).collect(Collectors.toList());

		 
		 return overduedList;
	 }
	
 
	 public StatisticsDto getStatistics() {
		 List<Task>  listTask=   getAllTask();
		 int numTasks = listTask.size();
		double completedTasks = 
				 listTask
				     .stream()
				     .filter(
				               p -> "completed".equalsIgnoreCase(p.getStatus())
				    ).count();
         double percentageCompleted =  (completedTasks/numTasks)*100;
         DecimalFormat df2 = new DecimalFormat(" #,##0.00 '%'");
         StatisticsDto statisticsDto = new StatisticsDto();
         statisticsDto.setTotalTasks(numTasks);
         statisticsDto.setCompletedTasks((int)completedTasks);
         statisticsDto.setCompletedTasksPercentage(df2.format(percentageCompleted).trim());
         
		 return statisticsDto;
	 }
	 public List<Task> getTasksCompleted(DatesDto datesDto) {
		 List<Task>  listTask=   getAllTask();
		List<Task> overduedList = 
				 listTask
				     .stream()
				     .filter( p -> "completed".equalsIgnoreCase(p.getStatus()))
				     .filter(
				               p -> (p.getEnddate().after(datesDto.getStartDate()) &&  p.getEnddate().before(datesDto.getEndDate()))
				    ).collect(Collectors.toList());

		 
		 return overduedList;
	 }
	 
	 
	@SuppressWarnings("deprecation")
	public Task assignTask(Long taskid,TaskAssignDto taskAssignDto) {
		User user = userRepository.getOne(taskAssignDto.getUserid());
		Task task = null;		
	if(null!=user) {
			task = taskRepository.getOne(taskid);
			task.setUserid(taskAssignDto.getUserid());
			task.setPrioritylevel(taskAssignDto.getPrioritylevel());
	 }
	
	return taskRepository.save(task);
	}
	
	public List<Task> getTasksbyUserid(Long userid){
		User user = userRepository.getOne(userid);
		List<Task> taskList = null;
		if(null!=user) {
			taskList = taskRepository.findByUserid(userid);
		}
		return taskList;
	}
	
	public List<Task> getTasksPriorityQueue(){
		 List<Task>  tasksforPriorityQueue=   getAllTask();
		 		 
				
		 		 PriorityQueue<Task> pq = new PriorityQueue<Task>(new Comparator<Task>() {
		             public int compare(Task Task1, Task Task2) {
		                //1st Level comparing
		         int duedateCompare = Task1.getDuedate().compareTo(
		             Task2.getDuedate());
		  
		         int prioritylevelCompare = Task1.getPrioritylevel().compareTo(
		             Task2.getPrioritylevel());
		  
		         // 2nd level comparison
		         return (duedateCompare == 0) ? prioritylevelCompare
		                                   : duedateCompare;
		    
		             }
		         });
		 		 
		 		 
		 		 pq.addAll(tasksforPriorityQueue);
		 		 
		 		 List<Task> PrioritytaskList = new ArrayList<Task>();
		 		while (!pq.isEmpty()) {
		 			PrioritytaskList.add(pq.poll());
		 		
		 		}
		 		
		 		 return PrioritytaskList;
		 		}
		 		 
	
	
}
