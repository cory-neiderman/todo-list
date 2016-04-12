package com.techelevator.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDAO implements UserDAO{

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCUserDAO(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public User getUserIdByNameAndPassword(String username, String password) {
		
		String sqlQueryForId = "SELECT user_id FROM member WHERE username=? AND password=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForId, username, password);
		
		if(results.next()){
		
	
		
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setUserId(results.getInt("user_id"));
		
		return user;
		}
		else
			return null;
		
	}

	@Override
	public boolean checkForUserName(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createNewUser(String username, String password) {
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT nextval('member_user_id_seq')");
		results.next();
		int userId = results.getInt(1);
		
		
		String sqlCreateNewUser = "INSERT INTO member(user_id, username, password) "+
				"VALUES(?,?,?)";
		
		jdbcTemplate.update(sqlCreateNewUser, userId, username, password );
		
		
	}

}
