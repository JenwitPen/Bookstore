package com.bank.bookstore.model;

import org.springframework.http.HttpStatus;

public class ResponseMessage {


	private Boolean ResponseStatus;
	public ResponseMessage(Boolean responseStatus, Object responseData, ResponseError errorMessage,
			org.springframework.http.HttpStatus httpStatus) {
		super();
		ResponseStatus = responseStatus;
		ResponseData = responseData;
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
	public ResponseError getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(ResponseError errorMessage) {
		ErrorMessage = errorMessage;
	}
	public HttpStatus getHttpStatus() {
		return HttpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		HttpStatus = httpStatus;
	}
	private Object ResponseData;
	private ResponseError ErrorMessage;
	private HttpStatus HttpStatus;
}
