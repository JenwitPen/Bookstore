package com.bank.bookstore.model;

import java.util.Date;

import org.springframework.boot.system.ApplicationPid;

public class ResponseSuccess {
	private Boolean result;
	ApplicationPid pid = new ApplicationPid();

	public ResponseSuccess() {
		super();
		this.result = true;
		this.successmessage = "Succeed";
		this.processid = pid.toString();
		this.timestamp = new Date();
	}

	public ResponseSuccess(Boolean result, String successmessage) {
		super();
		this.result = result;
		this.successmessage = successmessage;
		this.processid = pid.toString();
		this.timestamp = new Date();
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getSuccessmessage() {
		return successmessage;
	}

	public void setSuccessmessage(String successmessage) {
		this.successmessage = successmessage;
	}

	public String getProcessid() {
		return processid;
	}

	public void setProcessid(String processid) {
		this.processid = processid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	private String successmessage;
	private String processid;
	private Date timestamp;
}
