package com.bank.bookstore.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bank.bookstore.model.Request.BookRequest;
import com.bank.bookstore.model.Request.UserOrderRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
	@LocalServerPort
	int randomServerPort;
	@Value("${security.username}")
	private String username;
	@Value("${security.password}")
	private String password;
	String url="http://localhost:";
	RestTemplate restTemplate = new RestTemplate();
	@Test
	public void getAllBooksSuccess() throws URISyntaxException {
		

		final String baseUrl = url + randomServerPort + "/books";
		URI uri = new URI(baseUrl);
	//	restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("id"));
		Assert.assertEquals(true, result.getBody().contains("name"));
		Assert.assertEquals(true, result.getBody().contains("author"));
		Assert.assertEquals(true, result.getBody().contains("price"));
		Assert.assertEquals(true, result.getBody().contains("is_recommended"));
	}
	@Test
	public void getRecommendationBooksSuccess() throws URISyntaxException {


		final String baseUrl = url + randomServerPort + "/books/recommendation";
		URI uri = new URI(baseUrl);
	//	restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("id"));
		Assert.assertEquals(true, result.getBody().contains("name"));
		Assert.assertEquals(true, result.getBody().contains("author"));
		Assert.assertEquals(true, result.getBody().contains("price"));
		Assert.assertEquals(true, result.getBody().contains("is_recommended"));
	}
	@Test
	public void addBookSuccess() throws URISyntaxException {
	
		final String baseUrl = url + randomServerPort + "/books";
		URI uri = new URI(baseUrl);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));

		BookRequest bookRequest =new BookRequest("testbookname","testbook",200,false);

		ResponseEntity<String> result=restTemplate.postForEntity(uri, bookRequest,String.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("result"));
		Assert.assertEquals(true, result.getBody().contains("successmessage"));
		Assert.assertEquals(true, result.getBody().contains("processid"));
		Assert.assertEquals(true, result.getBody().contains("timestamp"));

	}
	
	
}
