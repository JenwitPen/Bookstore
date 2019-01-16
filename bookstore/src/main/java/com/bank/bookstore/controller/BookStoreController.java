package com.bank.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bookstore.dao.BookDAO;
import com.bank.bookstore.dao.UserDAO;
import com.bank.bookstore.model.Book;
import com.bank.bookstore.model.User;

@RestController
public class BookStoreController {
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllBooks() {
		List<Book> booklist = bookDAO.getAllBook();
		return ResponseEntity.status(HttpStatus.OK).body(booklist);
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUser() {
		List<User> userlist = userDAO.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(userlist);
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user ) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userDAO.addUser(user));
	}
}
