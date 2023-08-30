package com.tao.taskshedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	
	User(){}
	
	
	
	public User(Long userid, String username, String useraddr, String userphone) {
		super();
		this.userid = userid;
		this.username = username;
		this.useraddr = useraddr;
		this.userphone = userphone;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	
	private String username;
	private String useraddr;
	private String userphone;
	public Long getUserid() {
		return userid;
	}



	public void setUserid(Long userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUseraddr() {
		return useraddr;
	}



	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}



	public String getUserphone() {
		return userphone;
	}



	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	
	
	

}
