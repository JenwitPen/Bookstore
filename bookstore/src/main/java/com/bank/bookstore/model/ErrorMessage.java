package com.bank.bookstore.model;

import java.util.Date;

public class ErrorMessage {

	public String getErrorCode() {
		return errorCode;
	}
	public ErrorMessage(String errorCode, String errorMessage, String processId) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.processId = processId;
		this.timestamp = new Date();
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
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
	
	private String errorCode;
	private String errorMessage;
	private String processId;
	private Date timestamp;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}