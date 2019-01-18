package com.bank.bookstore.model;

import javax.validation.constraints.NotNull;

public class Order {

	public Order() {
		super();
	}
	public Order(@NotNull(message = "userid is a required field") int userid,
			@NotNull(message = "bookid is a required field") int bookid) {
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
	@NotNull(message = "userid is a required field")
	private int userid;
	@NotNull(message = "bookid is a required field")
	private int bookid;
}
