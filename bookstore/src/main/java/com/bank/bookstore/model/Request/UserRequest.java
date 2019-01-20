package com.bank.bookstore.model.Request;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class UserRequest{


	@NotNull(message = "name is a required field")
	@NotEmpty(message = "name is a required field")
	private String name;

	@NotNull(message = "surname is a required field")
	@NotEmpty(message = "surname is a required field")
	private String surname;

	@NotNull(message = "date_of_birth is a required field")
	private Date date_of_birth;

	@NotNull(message = "username is a required field")
	@NotEmpty(message = "username is a required field")
	private String username;

	@NotNull(message = "password is a required field")
	@NotEmpty(message = "password is a required field")
	private String password;





	



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

	public UserRequest(
			@NotNull(message = "name is a required field") @NotEmpty(message = "name is a required field") String name,
			@NotNull(message = "surname is a required field") @NotEmpty(message = "surname is a required field") String surname,
			@NotNull(message = "date_of_birth is a required field") Date date_of_birth,
			@NotNull(message = "username is a required field") @NotEmpty(message = "username is a required field") String username,
			@NotNull(message = "password is a required field") @NotEmpty(message = "password is a required field") String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.username = username;
		this.password = password;
	}

	public UserRequest() {
		super();

	}

}