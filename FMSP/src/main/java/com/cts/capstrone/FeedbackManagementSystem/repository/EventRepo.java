package com.cts.capstrone.FeedbackManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.capstrone.FeedbackManagementSystem.model.Event;
@Repository
public interface EventRepo extends JpaRepository<Event, Integer>{
	
	
}
	
	
	

