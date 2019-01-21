package com.bank.bookstore.model.DB;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDB {
	@Id
	private int id;

	private String name;

	private String surname;

	private Date date_of_birth;

	private String username;

	private String password;

	public UserDB(int id, String name, String surname, Date date_of_birth, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.username = username;
		this.password = password;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDB(String name, String surname, Date date_of_birth, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.username = username;
		this.password = password;
	}

	public UserDB() {
		super();

	}

}