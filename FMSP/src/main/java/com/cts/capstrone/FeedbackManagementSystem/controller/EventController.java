package com.cts.capstrone.FeedbackManagementSystem.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.server.reactive.ServerHttpResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.capstrone.FeedbackManagementSystem.mail.service.EmailService;
import com.cts.capstrone.FeedbackManagementSystem.model.Dashboard;
import com.cts.capstrone.FeedbackManagementSystem.model.Event;
import com.cts.capstrone.FeedbackManagementSystem.repository.EventRepo;
import com.cts.capstrone.FeedbackManagementSystem.service.EventRepoImpl;
import com.cts.capstrone.FeedbackManagementSystem.util.ExcelFileExporter;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events")
public class EventController {
	/*@Autowired
	public EventRepoImpl eventRepoImpl;*/

	@Autowired
	EmailService emailService;
	@Autowired
	public  EventRepo eventRepo;
	@GetMapping(value = "/getDashboardData", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('PMO') or hasRole('ADMIN')")
	public Dashboard dashboardData() {
		Dashboard dashBoard = new Dashboard();
		// int count=eventRepoImpl.getAllEvents();
		List<Event> m1 = eventRepo.findAll();
		m1.forEach(s -> dashBoard.setCount(Integer.parseInt(s.toString())));
		
		// m1.subscribe(s -> dashBoard.setCount(Integer.parseInt(s.toString())));
		// dashBoard.setCount(15);
		//Integer m2 = eventRepoImpl.getAllEvents().map(x -> x.getTotalVollunteers()).reduce(0, (a, b) -> a + b);
		List<Event> m2 = eventRepo.findAll();
		
		m2.forEach(s -> dashBoard.setTotalVolunteers(Integer.parseInt(s.toString())));

		//m2.subscribe(s -> dashBoard.setTotalVolunteers(Integer.parseInt(s.toString())));

		List<Event> m3 = eventRepo.findAll();//.map(x -> x.getLivesImpacted()).reduce(0, (a, b) -> a + b);
		m3.forEach(s -> dashBoard.setLivesImpacted(Integer.parseInt(s.toString())));
		List<Event> m4 = eventRepo.findAll();//.map(x -> x.getTotalParticipants()).reduce(0, (a, b) -> a + b);
		m4.forEach(s -> dashBoard.setTotalParticipants(Integer.parseInt(s.toString())));

		List<Dashboard> list = new ArrayList<>();
		list.add(dashBoard);
		return (Dashboard) list;

		//emailService.sendMail("sumansatpathy5@gmail.com", "FMS Report", "Hi,PFA");

		//return Flux.fromIterable(list);
		// return eventRepoImpl.getAllEvents().map(x->
		// x.getTotalVollunteers()).reduce(0, (a, b) -> a + b);
	}

	@GetMapping(value = "/allEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('PMO') or hasRole('ADMIN')")
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	/*@PostMapping(value = "/addEvent", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<ResponseEntity<Event>> saveEvent(@RequestBody Event event) {
		return eventRepo.save(event).map(savedEvent -> ResponseEntity.ok(savedEvent,HttpStatus.CREATED));
	}*/

	
	@GetMapping(value = "/eventDetails", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('PMO') or hasRole('ADMIN') or hasRole('POC')")
	public void getEventDetails(@RequestParam Integer eventId) {
		 eventRepo.findById(eventId);
	}

	@GetMapping(value = "/deleteEvent", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteEvent(@RequestParam Integer eventId) {
		 eventRepo.deleteById(eventId);
	}

	@GetMapping(value = "/deleteAllEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAllEvents() {
		eventRepo.deleteAll();
	}
	

	/*
	 * @GetMapping("/download/eventList.xlsx")
	 * 
	 * @PreAuthorize("hasRole('PMO') or hasRole('ADMIN')") public
	 * Mono<ServerResponse> downloadCsv(ServerRequest request,ServerResponse
	 * response) throws IOException {
	 * 
	 * response.set("application/octet-stream");
	 * response.setHeader("Content-Disposition",
	 * "attachment; filename=eventList.xlsx"); List<Event> list =new
	 * ArrayList<Event>();
	 * 
	 * eventRepoImpl.getAllEvents().subscribe(x-> list.add(x) );
	 * 
	 * //ByteArrayInputStream stream = Mono<byte[]>
	 * mono=Mono.just(ExcelFileExporter.eventListToExcelFile(list));
	 * Mono<ServerResponse> notFound = ServerResponse.notFound().build();
	 * 
	 * return mono.then(x ->
	 * ServerResponse.ok().contentType("application/octet-stream").body(fromObject(x
	 * ))) .otherwiseIfEmpty(notFound); //IOUtils.copy(stream, response.);
	 * 
	 * }
	 */
}
