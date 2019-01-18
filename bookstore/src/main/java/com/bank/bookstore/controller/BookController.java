package com.bank.bookstore.controller;



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

import com.bank.bookstore.model.Book;
import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.process.BookProcess;
import com.bank.bookstore.repository.BookRepository;


@RestController
public class BookController {
	

	HttpHeaders headers = new HttpHeaders();
	private static Logger logger = LogManager.getLogger(BookController.class);
	
	ResponseMessage responseMessage;
	@Autowired
	BookRepository bookrepository;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllBooks() {
		logger.info("Starting");
	
		BookProcess bookProcess = new BookProcess(bookrepository);
		responseMessage = bookProcess.getAllBooksProcess();

		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}

	}
	@RequestMapping(value = "/books/recommendation", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getRecommendationBooks() {
		logger.info("Starting");
	
		BookProcess bookProcess = new BookProcess(bookrepository);
		responseMessage = bookProcess.getRecommendationBooksProcess();

		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}

	}
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		logger.info("Starting");
	
		BookProcess bookProcess = new BookProcess(bookrepository);
		responseMessage = bookProcess.addBookProcess(book);
		logger.info("Finish");
		if (responseMessage.getResponseStatus()) {
			return new ResponseEntity<>(responseMessage.getResponseData(), headers, responseMessage.getHttpStatus());
		} else {
			return new ResponseEntity<>(responseMessage.getErrorMessage(), headers, responseMessage.getHttpStatus());
		}
	}
	
}
