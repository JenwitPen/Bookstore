package com.bank.bookstore.process;

import java.util.List;

import org.springframework.http.HttpStatus;


import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.User;
import com.bank.bookstore.repository.UserRepository;

public class UserProcess {

	private UserRepository userRepository;

	public UserProcess(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public ResponseMessage getAllUsersProcess() {
		try {
			List<User> uselist = userRepository.findAll();
			return new ResponseMessage(true, uselist, HttpStatus.OK);

		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage addUserProcess(User user) {
		try {
			return new ResponseMessage(true, userRepository.insert(user), HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}
	public ResponseMessage removeAllUser() {
		try {
			return new ResponseMessage(true, userRepository.deleteAll(), HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}
}