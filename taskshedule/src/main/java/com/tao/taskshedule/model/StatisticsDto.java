package com.tao.taskshedule.model;

public class StatisticsDto {
	
	public StatisticsDto() {}
	
	
	public StatisticsDto(int totalTasks, int completedTasks, String completedTasksPercentage) {
		super();
		this.totalTasks = totalTasks;
		this.completedTasks = completedTasks;
		this.completedTasksPercentage = completedTasksPercentage;
	}
	private int totalTasks;
	private int completedTasks;
	private String completedTasksPercentage;
	public int getTotalTasks() {
		return totalTasks;
	}


	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}


	public int getCompletedTasks() {
		return completedTasks;
	}


	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}


	public String getCompletedTasksPercentage() {
		return completedTasksPercentage;
	}


	public void setCompletedTasksPercentage(String completedTasksPercentage) {
		this.completedTasksPercentage = completedTasksPercentage;
	}


	

	
}	
