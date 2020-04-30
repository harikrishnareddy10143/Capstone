package com.cts.capstrone.FeedbackManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.capstrone.FeedbackManagementSystem.model.Event;
import com.cts.capstrone.FeedbackManagementSystem.repository.EventRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventRepoImpl {
	
	/*@Autowired(required=true)
	private EventRepo eventRepo;
	
	public List<Event> getAllEvents(){
		return eventRepo.findAll();
	}
	public Optional<Event> getEventDetailsById(Integer id){
		return eventRepo.findById(id);
	}
	
	public Event saveEvents(Event e) {
		return eventRepo.save(e);
	}
	
	public void deleteEvent(int eventId) {
		  eventRepo.deleteById(eventId);
	}
	
	public void deleteAllEvents() {
		eventRepo.deleteAll();
	}
	
	
*/}
