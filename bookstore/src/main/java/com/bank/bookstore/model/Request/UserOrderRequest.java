package com.bank.bookstore.model.Request;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class UserOrderRequest {

	
	public ArrayList<Integer> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Integer> orders) {
		this.orders = orders;
	}
	@NotNull(message = "userid is a required field")
	private int userid;
	public UserOrderRequest(@NotNull(message = "userid is a required field") int userid, ArrayList<Integer> orders) {
		super();
		this.userid = userid;
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
