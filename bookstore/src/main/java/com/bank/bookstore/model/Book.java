package com.bank.bookstore.model;

public class Book {
	private int id;
	private String name;
	private String author;
	private double price;
	private boolean is_recommended;

// Getter Methods 

	public int getId() {
		return id;
	}

	public Book(int id, String name, String author, double price, boolean is_recommended) {
		super();
		this.id = id;
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

	public void setId(int id) {
		this.id = id;
	}

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
