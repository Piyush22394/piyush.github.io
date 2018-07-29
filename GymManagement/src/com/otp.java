package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.DbConnection;

/**
 * Servlet implementation class otp
 */
@WebServlet("/otp")
public class otp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int len=6;
		
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		
		String values = numbers+Capital_chars+Small_chars;
		
		Random rnd = new Random();
		 
//	    char[] password = new char[len];
		
		  String password = "";
		  
	    for (int i = 0; i < len; i++)
	    {
	        password+=values.charAt(rnd.nextInt(values.length()));

	    }
	   // System.out.println(password);
	    
		String email = req.getParameter("eml");
		
		Connection con = null;
		PreparedStatement stmt=null;
		
			
		
		try
		{
			con = DbConnection.conn();
			Statement stmt1 = con.createStatement();
			stmt = con.prepareStatement("select * from login where Email=? ");
			stmt.setString(1,req.getParameter("eml"));
			
			String sql="update login set OTP='"+password.trim()+"' where Email='"+email+"'";
	        ResultSet rs = stmt.executeQuery();
	        stmt1.executeUpdate(sql);
	      
	        //RequestDispatcher dp=req.getRequestDispatcher("otp.jsp");
	        
	        if(rs.next()){
	        	
	        	String pass = rs.getString("Password");
	        	
	        	HttpSession session = req.getSession(true);
				session.setAttribute("Email", email);
				session.setAttribute("pswd", pass);
				
				System.out.println("old Password===>"+pass);
				System.out.println("OTP:-"+password);
				
				RequestDispatcher rd=req.getRequestDispatcher("SendPassword.jsp?vcode="+password);
				rd.include(req, res);
	        	//dp.include(req, res);
	         }
	         else {
	         
	         PrintWriter out=res.getWriter();
	        
	        
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Please enter valid Email id.');");
	         out.println("</script>");
	        
	         RequestDispatcher rd = req.getRequestDispatcher("/forgotpassword.jsp");
				rd.include(req, res);
	          
	        
	         
	         }
	        }catch(Exception ex){
	        System.out.println("Connection Error");
	        }	
		
		
	    
	}

}
