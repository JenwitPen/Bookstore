package com.bank.bookstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bank.bookstore.model.User;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setDate_of_birth(rs.getDate("date_of_birth"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;

		}

	}

	public List<User> findAll() {
		return jdbcTemplate.query("select * from user", new UserRowMapper());
	}

	public User findById(long id) {
		return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from user where id=?", new Object[] { id });
	}

	public int insert(User user) {
		return jdbcTemplate.update(
				"insert into user (name, surname, date_of_birth,username,password) " + "values(?,?,?,?,?)",
				new Object[] { user.getName(), user.getSurname(), user.getDate_of_birth(), user.getUsername(),
						user.getPassword() });
	}

	public int update(User user) {
		return jdbcTemplate.update(
				"update user " + " set name = ?, surname = ?, date_of_birth = ? , username = ? , password = ?  "
						+ " where id = ?",
				new Object[] { user.getName(), user.getSurname(), user.getDate_of_birth(), user.getUsername(),
						user.getPassword(), user.getId() });
	}
}
