package com.bank.bookstore.model.Request;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

public class UserOrderRequest {

	@NotNull(message = "userid is a required field")
	private int userid;
	public ArrayList<Integer> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Integer> orders) {
		this.orders = orders;
	}

	ArrayList<Integer> orders = new ArrayList<Integer>();

	// Getter Methods

	public int getUserid() {
		return userid;
	}

	// Setter Methods

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
