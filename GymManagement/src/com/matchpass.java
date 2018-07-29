package com;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.DbConnection;

/**
 * Servlet implementation class matchpass
 */
@WebServlet("/matchpass")
public class matchpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matchpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
				
		String p1 = req.getParameter("pass1");
		String p2 = req.getParameter("pass2");
	
		try {
			Connection con = DbConnection.conn();
			//String sql="update login set Password=? where FirstName='"+em+"' ";
			//PreparedStatement ps = con.prepareStatement(sql);
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(p1.equals(p2))
		{
			HttpSession session = req.getSession(true);
			session.setAttribute("pass", p1);
			
			RequestDispatcher rd = req.getRequestDispatcher("updatepass.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			 PrintWriter out=res.getWriter();
		        
		        
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Passwords Does not Match.');");
	         out.println("</script>");
	        
	         RequestDispatcher rd = req.getRequestDispatcher("/newpass.jsp");
				rd.include(req, res);
		}
	}

}
