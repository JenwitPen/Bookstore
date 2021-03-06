package com.bank.bookstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static Logger logger = LogManager.getLogger(UserRepository.class);

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
			logger.info("Starting");
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
		try {
			logger.info("Starting");
			return jdbcTemplate.query("select * from user where active=true", new UserRowMapper());
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public List<UserBookDB> findBookByUser(int userid) {
		try {
			logger.info("Starting");
			return jdbcTemplate.query(
					"select u.id as userid,u.date_of_birth,u.name,u.surname,o.bookid  from user as u  join `order`  as o on u.id=o.userid where u.active=true and u.id=?",
					new Object[] { userid }, new BeanPropertyRowMapper<UserBookDB>(UserBookDB.class));
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public List<UserDB> findRecomn() {
		try {
			return jdbcTemplate.query("select * from user where active=true", new UserRowMapper());
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public UserDB findById(long id) {
		try {
			logger.info("Starting");
			return jdbcTemplate.queryForObject("select * from user where active=true and id=?", new Object[] { id },
					new BeanPropertyRowMapper<UserDB>(UserDB.class));
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public UserDB findByName(String username) {
		try {
			logger.info("Starting");
			return jdbcTemplate.queryForObject("select * from user where active=true and username=?",
					new Object[] { username }, new BeanPropertyRowMapper<UserDB>(UserDB.class));
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int deleteById(long id) {
		try {
			logger.info("Starting");
			return jdbcTemplate.update("update  user set active=false where  id=?", new Object[] { id });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int deleteAll() {
		try {
			logger.info("Starting");
			return jdbcTemplate.update("update  user set active=false where (1=1)");
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int insert(UserDB userdb) {
		try {
			logger.info("Starting");
			return jdbcTemplate.update(
					"insert into user (name, surname, date_of_birth,username,password,createdate,createuser,active) "
							+ "values(?,?,?,?,?,?,?,?)",
					new Object[] { userdb.getName(), userdb.getSurname(), userdb.getDate_of_birth(),
							userdb.getUsername(), userdb.getPassword(), new Date(), "admin", true });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public double insertOrder(OrderDB orderdb) {
		try {
			logger.info("Starting");
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
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int update(UserDB user) {
		try {
			logger.info("Starting");
			return jdbcTemplate.update(
					"update user " + " set name = ?, surname = ?, date_of_birth = ? , username = ? , password = ?  "
							+ " where id = ?",
					new Object[] { user.getName(), user.getSurname(), user.getDate_of_birth(), user.getUsername(),
							user.getPassword(), user.getId() });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}
}
