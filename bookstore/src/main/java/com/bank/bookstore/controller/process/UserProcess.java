package com.bank.bookstore.controller.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.bank.bookstore.dao.BookDAO;
import com.bank.bookstore.dao.UserDAO;
import com.bank.bookstore.model.Book;
import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.User;

public class UserProcess {

	private UserDAO userDAO;

	public UserProcess(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public ResponseMessage getAllBooksProcess() {
		List<User> uselist = userDAO.getAllUser();
		ResponseMessage responseMessage = new ResponseMessage(true, uselist, HttpStatus.OK);

		return responseMessage;
	}

	public ResponseMessage addBookProcess(User user) {
		try {
			return new ResponseMessage(true, userDAO.addUser(user), HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}
}