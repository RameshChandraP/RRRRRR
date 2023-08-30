package com.tao.taskshedule.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tao.taskshedule.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	 public List<Task> findByUserid(Long userid);
	 public List<Task> findByStatus(String status);
	 public List<Task> findAll();
	
}
