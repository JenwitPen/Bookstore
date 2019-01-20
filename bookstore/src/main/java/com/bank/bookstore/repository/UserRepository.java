package com.bank.bookstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bank.bookstore.model.*;
import com.bank.bookstore.model.DB.*;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class UserRowMapper implements RowMapper<UserDB> {
		@Override
		public UserDB mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDB user = new UserDB();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setDate_of_birth(rs.getDate("date_of_birth"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;

		}

	}

	class OrderRowMapper implements RowMapper<OrderDB> {
		@Override
		public OrderDB mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderDB order = new OrderDB();
			order.setBookid(rs.getInt("bookid"));
			order.setUserid(rs.getInt("userid"));

			return order;

		}

	}

	class UserBookRowMapper implements RowMapper<UserBookDB> {
		@Override
		public UserBookDB mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBookDB userbook = new UserBookDB();
			userbook.setBookid(rs.getInt("bookid"));
			userbook.setDate_of_birth(rs.getDate("date_of_birth"));
			userbook.setName(rs.getString("name"));
			userbook.setSurname(rs.getString("surname"));
			userbook.setUserid(rs.getInt("userid"));
			return userbook;

		}

	}

	class BookRowMapper implements RowMapper<BookDB> {
		@Override
		public BookDB mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDB book = new BookDB();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setIs_recommended(rs.getBoolean("is_recommended"));
			return book;
		}

	}

	public List<UserDB> findAll() {
		return jdbcTemplate.query("select * from user where active=true", new UserRowMapper());
	}

	public List<UserBookDB> findBookByUser(int userid) {
		return jdbcTemplate.query(
				"select u.id as userid,u.date_of_birth,u.name,u.surname,o.bookid  from user as u  join `order`  as o on u.id=o.userid where u.active=true and u.id=?",
				new Object[] { userid }, new BeanPropertyRowMapper<UserBookDB>(UserBookDB.class));
	}

	public List<UserDB> findRecomn() {
		return jdbcTemplate.query("select * from user where active=true", new UserRowMapper());
	}

	public UserDB findById(long id) {
		return jdbcTemplate.queryForObject("select * from user where active=true and id=?", new Object[] { id },
				new BeanPropertyRowMapper<UserDB>(UserDB.class));
	}

	public UserDB findByName(String username) {
		return jdbcTemplate.queryForObject("select * from user where active=true and username=?", new Object[] { username },
				new BeanPropertyRowMapper<UserDB>(UserDB.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("update  user set active=false where  id=?", new Object[] { id });
	}

	public int deleteAll() {
		return jdbcTemplate.update("update  user set active=false where (1=1)");
	}

	public int insert(UserDB userdb) {
		return jdbcTemplate.update(
				"insert into user (name, surname, date_of_birth,username,password,createdate,createuser,active) "
						+ "values(?,?,?,?,?,?,?,?)",
				new Object[] { userdb.getName(), userdb.getSurname(), userdb.getDate_of_birth(), userdb.getUsername(),
						userdb.getPassword(), new Date(), "admin" ,true});
	}

	public double insertOrder(OrderDB orderdb) {
		double price = jdbcTemplate.queryForObject("select * from book where id=?",
				new Object[] { orderdb.getBookid() }, new BeanPropertyRowMapper<BookDB>(BookDB.class)).getPrice();
		if (price > 0) {
			int x = jdbcTemplate.update(
					"insert into `order` (bookid,userid,price,createdate,updatedate,createuser,updateuser,active) "
							+ "values(?,?,?,?,?,?,?,?)",
					new Object[] { orderdb.getBookid(), orderdb.getUserid(), price, new Date(), null, "admin", null,
							true });
			if (x > 0) {
				return price;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public int update(UserDB user) {
		return jdbcTemplate.update(
				"update user " + " set name = ?, surname = ?, date_of_birth = ? , username = ? , password = ?  "
						+ " where id = ?",
				new Object[] { user.getName(), user.getSurname(), user.getDate_of_birth(), user.getUsername(),
						user.getPassword(), user.getId() });
	}
}
