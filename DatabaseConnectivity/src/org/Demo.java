package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource datasource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//step1:Initialize connection objects
		PrintWriter out = response.getWriter();
		Connection connect = null;
	    Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = datasource.getConnection();
			//step2: create a SQL statements string
			String query = "select * from person";
			stmt = connect.createStatement();
			//step3: Execute sql query
			rs = stmt.executeQuery(query);
			
			//step4: process the result set
			while(rs.next()) {
				out.print("<br/>"+rs.getString("name"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
