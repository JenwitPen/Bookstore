package com.bank.bookstore.controller;



import javax.validation.Valid;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.bank.bookstore.model.*;
import com.bank.bookstore.model.Request.*;

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
		responseMessage = bookProcess.getAllUsersProcess();
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody @Valid UserRequest userRequest) {
		logger.info("Starting");
	
		
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.addUserProcess(userRequest);
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteUser() {
		logger.info("Starting");
	
		
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.removeAllUserProcess();
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	@RequestMapping(value = "/users/orders", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> orderBook(@RequestBody @Valid UserOrderRequest userOrderRequest) {
		logger.info("Starting");
	
		
		UserProcess bookProcess = new UserProcess(userRepository);
		responseMessage = bookProcess.insertOrderProcess(userOrderRequest);
		
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	
}

