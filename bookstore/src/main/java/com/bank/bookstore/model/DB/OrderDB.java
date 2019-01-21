package com.bank.bookstore.model.DB;

import javax.validation.constraints.NotNull;

public class OrderDB {

	private int userid;

	public OrderDB() {
		super();
	}

	public OrderDB(int userid, int bookid) {
		super();
		this.userid = userid;
		this.bookid = bookid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	private int bookid;

	// Getter Methods

}
