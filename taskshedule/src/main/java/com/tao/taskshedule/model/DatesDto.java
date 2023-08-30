package com.tao.taskshedule.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DatesDto implements Serializable{

	public DatesDto() {
	}

	public DatesDto(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
