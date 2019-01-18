package com.bank.bookstore.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bank.bookstore.model.Book;
@Repository
public class BookRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class BookRowMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setIs_recommended(rs.getBoolean("is_recommended"));
			return book;
		}

	}

	public List<Book> findAll() {
		return jdbcTemplate.query("select * from book", new BookRowMapper());
	}
	public List<Book> findRecommendation() {
		return jdbcTemplate.query("select * from book where is_recommended=true", new BookRowMapper());
	}
	
	public Book findById(long id) {
		return jdbcTemplate.queryForObject("select * from book where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from book where id=?", new Object[] { id });
	}
	
	public int insert(Book book) {
		return jdbcTemplate.update("insert into book (id, name, author,price,is_recommended) " + "values(?,?,?,?,?)",
				new Object[] { book.getId(), book.getName(), book.getAuthor(),book.getPrice(),book.getIs_recommended() });
	}

	public int update(Book book) {
		return jdbcTemplate.update("update book " + " set name = ?, author = ?, price = ? , is_recommended = ?  " + " where id = ?",
				new Object[] { book.getName(), book.getAuthor(),book.getPrice(),book.getIs_recommended(), book.getId() });
	}
}
