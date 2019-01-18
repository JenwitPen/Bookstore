package com.bank.bookstore.controller.process;

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
		try {

			bookDAO = null;
			List<Book> uselist = bookDAO.getAllBook();
			ResponseMessage responseMessage = new ResponseMessage(true, uselist, HttpStatus.OK);

			return responseMessage;
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage addBookProcess(Book book) {
		try {

			return new ResponseMessage(true, bookDAO.addBook(book), HttpStatus.OK);
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

}
