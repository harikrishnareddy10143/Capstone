/*
 * package com.cts.capstrone.FeedbackManagementSystem;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit.jupiter.SpringExtension; import
 * org.springframework.test.web.reactive.server.WebTestClient;
 * 
 * import com.cts.capstrone.FeedbackManagementSystem.model.Dashboard;
 * 
 * @ExtendWith(SpringExtension.class) //We create a `@SpringBootTest`, starting
 * an actual server on a `RANDOM_PORT`
 * 
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 * public class EventRouterTest {
 * 
 * // Spring Boot will create a `WebTestClient` for you, // already configure
 * and ready to issue requests against "localhost:RANDOM_PORT"
 * 
 * @Autowired private WebTestClient webTestClient;
 * 
 * @Test public void testHello() { webTestClient // Create a GET request to test
 * an endpoint .get().uri("/events/getDashboardData")
 * .accept(MediaType.TEXT_PLAIN) .exchange() // and use the dedicated DSL to
 * test assertions against the response .expectStatus().isOk()
 * .expectBody(Dashboard.class). } }
 */