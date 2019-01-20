package com.bank.bookstore.process;

import java.util.List;

import org.springframework.http.HttpStatus;


import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.DB.BookDB;
import com.bank.bookstore.model.Request.BookRequest;
import com.bank.bookstore.repository.BookRepository;

public class BookProcess {

	BookRepository bookrepository;

	public BookProcess(BookRepository bookrepository) {
		super();
		this.bookrepository = bookrepository;
	}

	public ResponseMessage getAllBooksProcess() {
		try {
			List<BookDB> uselist = bookrepository.findAll();
			ResponseMessage responseMessage = new ResponseMessage(true, uselist, null, HttpStatus.OK);

			return responseMessage;
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage getRecommendationBooksProcess() {
		try {
			List<BookDB> uselist = bookrepository.findRecommendation();
			return new ResponseMessage(true, uselist, null, HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage addBookProcess(BookRequest bookRequest) {
		try {
			BookDB book = new BookDB(bookRequest.getId(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getPrice(), bookRequest.getIs_recommended());
			return new ResponseMessage(true, bookrepository.insert(book), null, HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage getbookfindById(int bookid) {
		try {

			return new ResponseMessage(true, bookrepository.findById(bookid), null, HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}
}
