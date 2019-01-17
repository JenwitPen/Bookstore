package com.bank.bookstore.model;

import java.util.ArrayList;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	private int userid;
	@NotNull
	@NotEmpty(message = "name is a required field")
	
	private String name;
	@NotNull
	@NotEmpty(message = "surname is a required field")
	private String surname;
	private String date_of_birth;
	ArrayList<Object> books = new ArrayList<Object>();

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int userid, String name, String surname, String date_of_birth, ArrayList<Object> books) {
		super();
		this.userid = userid;
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.books = books;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public ArrayList<Object> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Object> books) {
		this.books = books;
	}

}