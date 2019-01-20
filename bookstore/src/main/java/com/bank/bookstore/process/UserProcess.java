package com.bank.bookstore.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.bank.bookstore.model.*;
import com.bank.bookstore.model.DB.*;
import com.bank.bookstore.model.Request.*;
import com.bank.bookstore.model.Response.*;
import com.bank.bookstore.repository.UserRepository;

public class UserProcess {

	private UserRepository userRepository;

	public UserProcess(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public ResponseMessage getAllUsersProcess() {
		try {
			List<UserDB> uselist = userRepository.findAll();

			List<UserResponse> userorderlist = new ArrayList<UserResponse>();
			for (UserDB user : uselist) {
				List<UserBookDB> orderlist = userRepository.findBookByUser(user.getId());
				ArrayList<Object> books = new ArrayList<Object>();
				for (UserBookDB order : orderlist) {
					books.add(order.getBookid());
				}
				UserResponse userOrder = new UserResponse(user.getName(), user.getSurname(), user.getDate_of_birth(),
						books);
				userorderlist.add(userOrder);
			}

			if (uselist.size() > 0) {
				return new ResponseMessage(true, userorderlist, null, HttpStatus.OK);
			} else {
				return new ResponseMessage(false, null, new ResponseError("No data"), HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}
	}

	public ResponseMessage addUserProcess(UserRequest userRequest) {
		try {
			UserDB userdb = new UserDB(userRequest.getName(), userRequest.getSurname(), userRequest.getDate_of_birth(),
					userRequest.getUsername(), userRequest.getPassword());
			int result = userRepository.insert(userdb);
			if (result > 0) {

				return new ResponseMessage(true, new ResponseSuccess(), null, HttpStatus.OK);
			} else {
				return new ResponseMessage(false, null, new ResponseError("insert fail"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}

	public ResponseMessage removeAllUserProcess() {
		try {
			int result = userRepository.deleteAll();

			if (result > 0) {

				return new ResponseMessage(true, new ResponseSuccess(), null, HttpStatus.OK);
			} else {
				return new ResponseMessage(false, null, new ResponseError("insert fail"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}

	public ResponseMessage insertOrderProcess(UserOrderRequest userOrderRequest) {
		try {
			Double price = 0.0;

			for (Integer or : userOrderRequest.getOrders()) {
				OrderDB order = new OrderDB();
				order.setBookid(or);
				order.setUserid(userOrderRequest.getUserid());
				price += userRepository.insertOrder(order);
			}
			if (price > 0) {
				return new ResponseMessage(true, new UserOrderResonse(price), null, HttpStatus.OK);
			} else {
				return new ResponseMessage(false, null, new ResponseError("order fail"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception ex) {
			throw new java.lang.RuntimeException(ex);
		}

	}
}