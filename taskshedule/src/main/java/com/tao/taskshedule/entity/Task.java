package com.tao.taskshedule.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {
	
	public Task() {}
	

	public Task(Long taskid, String task, String description, Date duedate, String status, Long progresspercentage,
			Date startdate, Date enddate, String prioritylevel, Long userid) {
		super();
		this.taskid = taskid;
		this.task = task;
		this.description = description;
		this.duedate = duedate;
		this.status = status;
		this.progresspercentage = progresspercentage;
		this.startdate = startdate;
		this.enddate = enddate;
		this.prioritylevel = prioritylevel;
		this.userid = userid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskid;
	
	private String task;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date duedate;
	private String status;
	private Long progresspercentage;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	private String prioritylevel;
	private Long userid;
	public Long getTaskid() {
		return taskid;
	}


	public void setTaskid(Long taskid) {
		this.taskid = taskid;
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