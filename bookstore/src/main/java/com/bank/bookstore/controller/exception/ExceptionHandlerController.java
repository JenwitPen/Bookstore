package com.bank.bookstore.controller.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.system.ApplicationPid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.bookstore.model.ErrorMessage;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	HttpHeaders headers = new HttpHeaders();
	ApplicationPid pid = new ApplicationPid();

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

//	  ErrorMessage errorDetails = new ErrorMessage(new Date(), ex.getMessage(),
//        request.getDescription(false));
		ErrorMessage errorDetails = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(),
				pid.toString());

		return new ResponseEntity<>(errorDetails, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//  @ExceptionHandler(StudentNotFoundException.class)
//  public final ResponseEntity<Object> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
//    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
//        request.getDescription(false));
//    return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
//  }

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final List<String> errors = new ArrayList<String>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		ErrorMessage errorDetails = new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors.toString(),
				pid.toString());

		return new ResponseEntity<>(errorDetails, headers, HttpStatus.BAD_REQUEST);

	}

}
