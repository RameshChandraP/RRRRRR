package com.tao.taskshedule.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

	private Long taskId;
	private String task;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date duedate;
	private String status;
	private Long progresspercentage;
	private Date startdate;
	private Date enddate;
	private String prioritylevel;
	private Long userid;
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProgresspercentage() {
		return progresspercentage;
	}

	public void setProgresspercentage(Long progresspercentage) {
		this.progresspercentage = progresspercentage;
	}

	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getPrioritylevel() {
		return prioritylevel;
	}
	public void setPrioritylevel(String prioritylevel) {
		this.prioritylevel = prioritylevel;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

}