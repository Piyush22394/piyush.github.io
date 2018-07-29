package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DbConnection;

/**
 * Servlet implementation class enquiry
 */
@WebServlet("/enquiry")
public class enquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name1 = req.getParameter("firstname");
		String name2 = req.getParameter("lastname");
		String email1 = req.getParameter("Email");
		String msg = req.getParameter("messege");
		
		try {
			
			
			Connection con = DbConnection.conn();
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("insert into enquiry values('"+name1+"','"+name2+"','"+email1+"','"+msg+"')");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		res.sendRedirect("index.html");
		
		
		
	}

}
