package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DbConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
			
			String fname = req.getParameter("Firstname");
			String lname = req.getParameter("Lastname");
			String mail = req.getParameter("email");
			String user=req.getParameter("user");
			String pswd = req.getParameter("password");
			String c = null;
			//ResultSet rs = null;
			try {
				
			
				Connection con = DbConnection.conn();
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("insert into login values('"+fname+"','"+lname+"','"+mail+"','"+user+"','"+pswd+"','"+c+"')");
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//PrintWriter out=res.getWriter();
			//out.print("welcome "+"  "+user);	
			
		RequestDispatcher rd = req.getRequestDispatcher("/index.html");
				rd.forward(req, res);
			
			
			//res.sendRedirect("index.jsp");
			//out.print(str1);
			System.out.println("Sign up Successfully..!");
			
			
	}

}
