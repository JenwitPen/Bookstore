package com.bank.bookstore.model;

import org.springframework.http.HttpStatus;

public class ResponseMessage {

	public ResponseMessage(Boolean responseStatus, Object responseData,
			org.springframework.http.HttpStatus httpStatus) {
		super();
		ResponseStatus = responseStatus;
		ResponseData = responseData;

		HttpStatus = httpStatus;
	}

	public ResponseMessage(Boolean responseStatus, com.bank.bookstore.model.ErrorMessage errorMessage,
			org.springframework.http.HttpStatus httpStatus) {
		super();
		ResponseStatus = responseStatus;

		ErrorMessage = errorMessage;
		HttpStatus = httpStatus;
	}

	public Boolean getResponseStatus() {
		return ResponseStatus;
	}

	public void setResponseStatus(Boolean responseStatus) {
		ResponseStatus = responseStatus;
	}

	public Object getResponseData() {
		return ResponseData;
	}

	public void setResponseData(Object responseData) {
		ResponseData = responseData;
	}

	public ErrorMessage getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		ErrorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return HttpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		HttpStatus = httpStatus;
	}

	private Boolean ResponseStatus;
	private Object ResponseData;
	private ErrorMessage ErrorMessage;
	private HttpStatus HttpStatus;
}
