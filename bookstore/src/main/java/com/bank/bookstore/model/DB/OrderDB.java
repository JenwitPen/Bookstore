package com.bank.bookstore.model.DB;

import javax.validation.constraints.NotNull;

public class OrderDB {


	@NotNull(message = "userid is a required field")
	 private int userid;
	public OrderDB() {
		super();
	}
	public OrderDB(@NotNull(message = "userid is a required field") int userid,
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
	@NotNull(message = "bookid is a required field")
	private int bookid;

	 // Getter Methods 

	
}
