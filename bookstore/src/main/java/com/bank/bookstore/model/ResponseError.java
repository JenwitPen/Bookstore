package com.bank.bookstore.model;

import java.util.Date;

import org.springframework.boot.system.ApplicationPid;

public class ResponseError {
	ApplicationPid pid = new ApplicationPid();

	public ResponseError(String errormessage) {
		super();
		this.result=false;
		this.errormessage = errormessage;
		this.processid = pid.toString();
		this.timestamp = new Date();
	}
	public String getprocessid() {
		return processid;
	}
	public void setprocessid(String processid) {
		this.processid = processid;
	}

	public String geterrormessage() {
		return errormessage;
	}
	public void seterrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
	private Boolean result;
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}

	private String errormessage;
	private String processid;
	private Date timestamp;
	public Date gettimestamp() {
		return timestamp;
	}
	public void settimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}