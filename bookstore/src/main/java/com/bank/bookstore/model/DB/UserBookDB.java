package com.bank.bookstore.model.DB;

import java.util.Date;

public class UserBookDB {
	
	public UserBookDB() {
		super();
	}
	public UserBookDB(int userid, int bookid, String name, String surname, Date date_of_birth) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	private int userid;
	private int bookid;
	private String name;
	private String surname;
	private Date date_of_birth;

}
