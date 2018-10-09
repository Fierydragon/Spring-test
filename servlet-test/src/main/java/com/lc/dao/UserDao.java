package com.lc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lc.pojo.User;
import com.lc.service.ConnectionPool;

public class UserDao {
	
	public void add(User user) throws SQLException {
		Connection connection = ConnectionPool.getConnection();
		try {
			String sql = "INSERT INTO servlet_test.user(name, age, sex) VALUES(?, ?, ?)";
			PreparedStatement s = connection.prepareStatement(sql);
			
			s.setString(1, user.getName());
			s.setInt(2, user.getAge());
			s.setString(3, user.getSex());
			
			s.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw e;
		}
	}
}
