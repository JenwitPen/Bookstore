package com.bank.bookstore.model.Response;

public class UserOrderResonse {
	private double price;

	public UserOrderResonse(double price) {
		super();
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
