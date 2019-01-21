package com.bank.bookstore.model.Request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class BookRequest {

	@NotNull(message = "name is a required field")
	@NotEmpty(message = "name is a required field")	
	private String name;
	
	@NotNull(message = "author is a required field")
	@NotEmpty(message = "author is a required field")	
	private String author;
	
	@NotNull(message = "price is a required field")
	private double price;
	
	@NotNull(message = "is_recommended is a required field")
	private boolean is_recommended;

// Getter Methods 
	public BookRequest() {
		super();
		
	}
	


	public BookRequest(
			@NotNull(message = "name is a required field") @NotEmpty(message = "name is a required field") String name,
			@NotNull(message = "author is a required field") @NotEmpty(message = "author is a required field") String author,
			@NotNull(message = "price is a required field") double price,
			@NotNull(message = "is_recommended is a required field") boolean is_recommended) {
		super();

		this.name = name;
		this.author = author;
		this.price = price;
		this.is_recommended = is_recommended;
	}
	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public boolean getIs_recommended() {
		return is_recommended;
	}

// Setter Methods 

	

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setIs_recommended(boolean is_recommended) {
		this.is_recommended = is_recommended;
	}
}
