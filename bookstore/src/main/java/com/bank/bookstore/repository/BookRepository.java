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

import com.bank.bookstore.controller.BookController;
import com.bank.bookstore.model.DB.BookDB;

@Repository
public class BookRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static Logger logger = LogManager.getLogger(BookRepository.class);

	class BookDBRowMapper implements RowMapper<BookDB> {
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

	public List<BookDB> findAll() {
		try {
			logger.info("Starting");
			
			return jdbcTemplate.query("select * from book where active=true order by is_recommended desc",
					new BookDBRowMapper());
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
		
	}

	public List<BookDB> findRecommendation() {
		try {
			logger.info("Starting");
			return jdbcTemplate.query("select * from book where active=true and is_recommended=true",
					new BookDBRowMapper());
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public BookDB findById(long id) {
		try {
			logger.info("Starting");
			return jdbcTemplate.queryForObject("select * from book where active=true and id=?", new Object[] { id },
					new BeanPropertyRowMapper<BookDB>(BookDB.class));
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
			return jdbcTemplate.update("update  book set active=false where id=?", new Object[] { id });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int insert(BookDB book) {
		try {
			logger.info("Starting");
			return jdbcTemplate.update(
					"insert into book ( name, author,price,is_recommended,createdate,updatedate,createuser,updateuser,active) "
							+ "values(?,?,?,?,?,?,?,?,?)",
					new Object[] { book.getName(), book.getAuthor(), book.getPrice(), book.getIs_recommended(),
							new Date(), null, "admin", null, true });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}

	public int update(BookDB book) {
		try {
			logger.info("Starting");
			return jdbcTemplate.update(
					"update book " + " set name = ?, author = ?, price = ? , is_recommended = ?  " + " where id = ?",
					new Object[] { book.getName(), book.getAuthor(), book.getPrice(), book.getIs_recommended(),
							book.getId() });
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		} finally {
			logger.info("Finish");
		}
	}
}
