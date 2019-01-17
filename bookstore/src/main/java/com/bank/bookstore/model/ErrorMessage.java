package com.bank.bookstore.model;

public class ErrorMessage {
	public ErrorMessage(String errorCode, String errorMessage, String requestId) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestId = requestId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	private String errorCode;
	private String errorMessage;
	private String requestId;
}
