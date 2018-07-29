package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DbConnection;

/**
 * Servlet implementation class addmember
 */
@SuppressWarnings("unused")
@WebServlet("/addmember")
public class addmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fname = req.getParameter("Firstname");
		String lname = req.getParameter("Lastname");
		String mob=req.getParameter("mobile");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String ht =req.getParameter("height") ;
		String wt =req.getParameter("weight") ;
		
		LocalDate reg = java.time.LocalDate.now();
		
		//System.out.println(reg);
		String exp = req.getParameter("expdate");
	//ResultSet rs = null;
		try {
			
		
			Connection con = DbConnection.conn();
			Statement stmt = con.createStatement();//sql Statement
			
		
stmt.executeUpdate("insert into member values('"+fname+"','"+lname+"','"+mob+"','"+email+"','"+gender+"','"+ht+"','"+wt+"','"+reg+"','"+reg+"')");

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//PrintWriter out=res.getWriter();
		//out.print("welcome "+"  "+user);	
		
	
		res.sendRedirect("index.html");
		//out.print(str1);
		System.out.println("Member Registered Successfully..!");
	}

}
