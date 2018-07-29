package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DbConnection;

//import com.mysql.jdbc.Connection;

import Connection.DbConnection;

/**
 * Servlet implementation class votp
 */
@WebServlet("/votp")
public class votp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public votp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String c = req.getParameter("vcode");
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DbConnection.conn();
			
			
			stmt = con.prepareStatement("select * from login where OTP=? ");
			stmt.setString(1,req.getParameter("vcode"));
				        
	         ResultSet rs = stmt.executeQuery();
	      	        
	         RequestDispatcher dp=req.getRequestDispatcher("newpass.jsp");
	         
	         if(rs.next()){
	     
	        	 dp.forward(req,res);
	         }
	         else {
	         
	         PrintWriter out=res.getWriter();
	        
	        
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Please enter valid OTP.');");
	         out.println("</script>");
	        
	         RequestDispatcher rd = req.getRequestDispatcher("/otp.jsp");
				rd.include(req, res);
	          
	        
	         
	         }
	        }catch(Exception ex){
	        System.out.println("Connection Error");
	        }	
		
	}

}
