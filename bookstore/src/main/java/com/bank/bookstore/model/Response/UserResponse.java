package com.bank.bookstore.model.Response;
import java.util.ArrayList;
import java.util.Date;
public class UserResponse {


	public UserResponse(String name, String surname, Date date_of_birth, ArrayList<Object> books) {
		super();
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.books = books;
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
	public ArrayList<Object> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Object> books) {
		this.books = books;
	}
	private String name;
	private String surname;
	private Date date_of_birth;
	ArrayList<Object> books = new ArrayList<Object>();
}
