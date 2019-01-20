package com.bank.bookstore.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

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
import com.bank.bookstore.model.Request.UserRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@LocalServerPort
	int randomServerPort;
	@Value("${security.username}")
	private String username;
	@Value("${security.password}")
	private String password;
	String url="http://localhost:";
	RestTemplate restTemplate = new RestTemplate();
	@Test
	public void getAllUserSuccess() throws URISyntaxException {
		

		final String baseUrl = url + randomServerPort + "/users";
		URI uri = new URI(baseUrl);
	//	restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("name"));
		Assert.assertEquals(true, result.getBody().contains("surname"));
		Assert.assertEquals(true, result.getBody().contains("date_of_birth"));
		Assert.assertEquals(true, result.getBody().contains("books"));
		
	}
	@Test
	public void addUserSuccess() throws URISyntaxException {
	
		final String baseUrl = url + randomServerPort + "/users";
		URI uri = new URI(baseUrl);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));

		UserRequest userRequest=new UserRequest("testname","testsurname",new Date(),"user","pass");
	

		ResponseEntity<String> result=restTemplate.postForEntity(uri, userRequest,String.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("result"));
		Assert.assertEquals(true, result.getBody().contains("successmessage"));
		Assert.assertEquals(true, result.getBody().contains("processid"));
		Assert.assertEquals(true, result.getBody().contains("timestamp"));

	}
	@Test
	public void orderBookSuccess() throws URISyntaxException {
	
		final String baseUrl = url + randomServerPort + "/users/orders";
		URI uri = new URI(baseUrl);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
		ArrayList<Integer> arr	=new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		UserOrderRequest userOrderRequest =new UserOrderRequest(1,arr);

		ResponseEntity<String> result=restTemplate.postForEntity(uri, userOrderRequest,String.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("price"));
	

	}
	
	@Test
	public void deleteUser() throws URISyntaxException {
	
		final String baseUrl = url + randomServerPort + "/users";
		URI uri = new URI(baseUrl);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
	

	
		ResponseEntity<String> result=restTemplate.exchange(uri, HttpMethod.DELETE,null,String.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("result"));
		Assert.assertEquals(true, result.getBody().contains("successmessage"));
		Assert.assertEquals(true, result.getBody().contains("processid"));
		Assert.assertEquals(true, result.getBody().contains("timestamp"));
	

	}
}
