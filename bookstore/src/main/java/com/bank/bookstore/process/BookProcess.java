package com.bank.bookstore.process;

import java.util.List;


import org.springframework.http.HttpStatus;

import com.bank.bookstore.model.Book;
import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.repository.BookRepository;

public class BookProcess {

	BookRepository bookrepository;
	
	public BookProcess(BookRepository bookrepository) {
		super();
		this.bookrepository = bookrepository;
	}

	public ResponseMessage getAllBooksProcess() {
		try {		
			List<Book> uselist = bookrepository.findAll();
			ResponseMessage responseMessage = new ResponseMessage(true, uselist, HttpStatus.OK);

			return responseMessage;
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage addBookProcess(Book book) {
		try {

			return new ResponseMessage(true, bookrepository.insert(book), HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

}
