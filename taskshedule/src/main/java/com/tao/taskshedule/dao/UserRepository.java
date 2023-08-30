package com.tao.taskshedule.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tao.taskshedule.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// public Task findByTask(String task);

	// public List<Task> findByCompletedTrue();
	// public List<Task> findByStatus(String status);
	public List<User> findAll();

}
