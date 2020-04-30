package com.cts.capstrone.FeedbackManagementSystem.configuration;

import java.time.Duration;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.capstrone.FeedbackManagementSystem.model.Event;
import com.cts.capstrone.FeedbackManagementSystem.repository.EventRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EventHandler {
	private EventRepo eventRepo;

	public EventHandler(EventRepo eventRepo) {
		this.eventRepo = eventRepo;
	}

	/*public Mono<ServerResponse> addEvent(ServerRequest request) {
	Event eventMono = request.bodyToMono(Event.class).flatMap(event -> eventRepo.save(event));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(eventMono, Event.class);
	}*/

	public Mono<ServerResponse> getAllEvents(ServerRequest request) {
		List<Event> event = eventRepo.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(event, Event.class);
	}

	/*
	 * public Mono<ServerResponse> getUserById(ServerRequest request) { String
	 * userId = request.pathVariable("userId"); Mono<ServerResponse> notFound =
	 * ServerResponse.notFound().build(); Mono<Event> userMono =
	 * eventRepo.findById(userId); return userMono .flatMap(user ->
	 * ServerResponse.ok().contentType(APPLICATION_JSON).body(BodyInserters.
	 * fromObject(user))) .switchIfEmpty(notFound); }
	 */

	/*
	 * public Mono<ServerResponse> deleteUser(ServerRequest request) { String userId
	 * = request.pathVariable("userId"); userRepository.deleteById(userId); return
	 * ServerResponse.ok().build(); }
	 */
	/*
	 * public Mono<ServerResponse> streamEvents(ServerRequest serverRequest){ return
	 * ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(Flux.
	 * interval(Duration.ofSeconds(1)) .map(val -> new Event("" + val,
	 * "Devglan User Event")), Event.class); }
	 */
}
