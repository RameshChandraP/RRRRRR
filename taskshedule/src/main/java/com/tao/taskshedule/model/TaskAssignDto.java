package com.tao.taskshedule.model;

import java.io.Serializable;

public class TaskAssignDto implements Serializable{

	TaskAssignDto() {
	}

	public TaskAssignDto(Long userid, String prioritylevel) {
		super();
		this.userid = userid;
		this.prioritylevel = prioritylevel;
	}

	private Long userid;
	private String prioritylevel;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getPrioritylevel() {
		return prioritylevel;
	}

	public void setPrioritylevel(String prioritylevel) {
		this.prioritylevel = prioritylevel;
	}

}
