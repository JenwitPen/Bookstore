package com.bank.bookstore.controller;



import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.User;
import com.bank.bookstore.process.UserProcess;
import com.bank.bookstore.repository.UserRepository;
@RestController
public class UserController {

	ResponseMessage responseMessage;
	HttpHeaders headers = new HttpHeaders();
	private static Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUser() {		
		logger.info("Starting");
	
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.getAllBooksProcess();
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
		logger.info("Starting");
	
		
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.addBookProcess(user);
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteUser(@RequestBody @Valid User user) {
		logger.info("Starting");
	
		
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.addBookProcess(user);
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
}

