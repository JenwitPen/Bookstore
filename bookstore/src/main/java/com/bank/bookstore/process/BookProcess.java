package com.bank.bookstore.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.bank.bookstore.dao.BookDAO;
import com.bank.bookstore.model.Book;
import com.bank.bookstore.model.ResponseMessage;



public class BookProcess {
	private BookDAO bookDAO;
	public BookProcess(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}

	
	
	public ResponseMessage getAllBooksProcess() {
		List<Book> uselist = bookDAO.getAllBook();
		ResponseMessage responseMessage = new ResponseMessage(true, uselist, HttpStatus.OK);

		return responseMessage;
	}

	public ResponseMessage addBookProcess(Book book) {

		return new ResponseMessage(true, bookDAO.addBook(book), HttpStatus.OK);

	}

}
