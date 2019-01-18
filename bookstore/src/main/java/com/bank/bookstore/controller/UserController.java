package com.bank.bookstore.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bank.bookstore.controller.process.BookProcess;
import com.bank.bookstore.controller.process.UserProcess;
import com.bank.bookstore.dao.UserDAO;
import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.User;

import javax.validation.Valid;
@RestController
public class UserController {

	ResponseMessage responseMessage;
	HttpHeaders headers = new HttpHeaders();
	private static Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUser() {		
		logger.info("Starting");
		headers.add("Custom-Header", "foo");
		UserProcess bookProcess = new UserProcess(userDAO);
		responseMessage = bookProcess.getAllBooksProcess();
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
		logger.info("Starting");
		headers.add("Custom-Header", "foo");
		
		UserProcess bookProcess = new UserProcess(userDAO);
		responseMessage = bookProcess.addBookProcess(user);
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	
}

