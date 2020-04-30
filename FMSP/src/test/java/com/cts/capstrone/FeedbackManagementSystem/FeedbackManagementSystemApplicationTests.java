package com.cts.capstrone.FeedbackManagementSystem;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.cts.capstrone.FeedbackManagementSystem.model.Event;
import com.cts.capstrone.FeedbackManagementSystem.repository.EventRepo;

import reactor.core.publisher.Mono;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeedbackManagementSystemApplicationTests {
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
    EventRepo eventRepo;
	@Test
	public void testCreateEvent() {
		Event e=new Event();
		e.setEventId(1);
		e.setEventName("Skin Cancer Awareness In Holi");
		e.setBusinessUnit("Health Care");
		e.setVenue("DLF Hyderbad");
		e.setEventDate("2020-03-11");
		e.setTotalVollunteers(5);
		e.setVallunteerHours(15);
		e.setTravelHours(4);
		
		webTestClient.post().uri("/events/addEvent")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .body(Mono.just(e), Event.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
        .jsonPath("$.eventId").isNotEmpty()
        .jsonPath("$.eventName").isEqualTo("Skin Cancer Awareness In Holi");
		
	}
	@Test
	public void testGetAllEvents() {
		webTestClient.get().uri("/events/allEvents")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
        .expectBodyList(Event.class);
	}

}
