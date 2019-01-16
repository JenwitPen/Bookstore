package com.bank.bookstore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.bookstore.model.User;
@Repository
public class UserDAO {
	private static final Map<String, User> hashMap = new HashMap<String, User>();

	static {
		initEmps();
	}

	private static void initEmps() {
		ArrayList<Object> books1 = new ArrayList<Object>();
		books1.add(1);
		books1.add(4);
		ArrayList<Object> books2 = new ArrayList<Object>();
		books2.add(2);
		books2.add(3);
		User user1 = new User(1, "Jenwit", "Penjamrat", "15/01/1985", books1);
		User user2 = new User(2, "Somsal", "Srinak", "11/02/1990", books2);

		hashMap.put(Integer.toString(user1.getUserid()), user1);
		hashMap.put(Integer.toString(user2.getUserid()), user2);

	}

	public User getUser(String userid) {
		return hashMap.get(userid);
	}

	public User addUser(User user) {
		hashMap.put(Integer.toString(user.getUserid()), user);
		return user;
	}

	public User updateUser(User user) {
		hashMap.put(Integer.toString(user.getUserid()), user);
		return user;
	}

	public void deleteUser(String userid) {
		hashMap.remove(userid);
	}

	public List<User> getAllUser() {
		Collection<User> c = hashMap.values();
		List<User> list = new ArrayList<User>();
		list.addAll(c);
		return list;
	}
}
