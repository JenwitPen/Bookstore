package com.bank.bookstore.model;

import java.util.Date;

public class ResponseError {

	public String geterrorcode() {
		return errorcode;
	}
	public ResponseError(String errorcode, String errormessage, String processid) {
		super();
		this.errorcode = errorcode;
		this.errormessage = errormessage;
		this.processid = processid;
		this.timestamp = new Date();
	}
	public String getprocessid() {
		return processid;
	}
	public void setprocessid(String processid) {
		this.processid = processid;
	}
	public void seterrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String geterrormessage() {
		return errormessage;
	}
	public void seterrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
	private String errorcode;
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