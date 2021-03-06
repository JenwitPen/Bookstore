package com.bank.bookstore.process;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.bank.bookstore.controller.BookController;
import com.bank.bookstore.model.ResponseError;
import com.bank.bookstore.model.ResponseMessage;
import com.bank.bookstore.model.ResponseSuccess;
import com.bank.bookstore.model.DB.BookDB;
import com.bank.bookstore.model.Request.BookRequest;
import com.bank.bookstore.repository.BookRepository;

public class BookProcess {

	BookRepository bookrepository;
	private static Logger logger = LogManager.getLogger(BookProcess.class);

	public BookProcess(BookRepository bookrepository) {
		super();
		this.bookrepository = bookrepository;
		logger.info("Starting");
	}

	public ResponseMessage getAllBooksProcess() {
		try {
		
			List<BookDB> uselist = bookrepository.findAll();
			ResponseMessage responseMessage = new ResponseMessage(true, uselist, null, HttpStatus.OK);

			return responseMessage;
		} catch (Exception ex) {
			logger.error(ex);
			throw new java.lang.RuntimeException("Error process!  Please contact the IT department.");
		} finally {
			logger.info("Finish");
		}
	}

	public ResponseMessage getRecommendationBooksProcess() {
		try {
			List<BookDB> uselist = bookrepository.findRecommendation();
			return new ResponseMessage(true, uselist, null, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex);
			throw new java.lang.RuntimeException("Error process!  Please contact the IT department.");
		} finally {
			logger.info("Finish");
		}
	}

	public ResponseMessage addBookProcess(BookRequest bookRequest) {
		try {
			BookDB book = new BookDB(0, bookRequest.getName(), bookRequest.getAuthor(), bookRequest.getPrice(),
					bookRequest.getIs_recommended());

			int result = bookrepository.insert(book);
			if (result > 0) {

				return new ResponseMessage(true, new ResponseSuccess(), null, HttpStatus.OK);
			} else {
				return new ResponseMessage(false, null, new ResponseError("insert fail"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception ex) {
			logger.error(ex);
			throw new java.lang.RuntimeException("Error process!  Please contact the IT department.");
		} finally {
			logger.info("Finish");
		}
	}

	public ResponseMessage getbookfindById(int bookid) {
		try {

			return new ResponseMessage(true, bookrepository.findById(bookid), null, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex);
			throw new java.lang.RuntimeException("Error process!  Please contact the IT department.");
		} finally {
			logger.info("Finish");
		}
	}
}
