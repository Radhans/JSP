package org.model;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.entity.User;

public class UsersModel {
	
	public List<User> listUsers(DataSource dataSource){
		List<User> listUsers = new ArrayList<>();
		
		
				Connection connect = null;
			    Statement stmt = null;
				ResultSet rs = null;
				try {
					connect = dataSource.getConnection();
					//step2: create a SQL statements string
					String query = "select * from users";
					stmt = connect.createStatement();
					//step3: Execute sql query
					rs = stmt.executeQuery(query);
					
					//step4: process the result set
					while(rs.next()) {
						listUsers.add(new User(rs.getInt("users_id"),rs.getString("username"),rs.getString("email")));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
					
				}
				return listUsers;
				
				
			}
	}


