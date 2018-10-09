package com.lc.service;

import java.sql.SQLException;

import com.lc.dao.UserDao;
import com.lc.pojo.User;

public class UserService {
	UserDao dao = new UserDao();

	public void add(User user) {
		try {
			dao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("==========Rollback==========");
				ConnectionPool.getConnection().rollback();
				System.out.println("==========Rollback Success==========");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}
}
