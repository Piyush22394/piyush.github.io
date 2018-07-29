package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.DbConnection;

/**
 * Servlet implementation class adminvalidate
 */
@WebServlet("/adminvalidate")
public class adminvalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminvalidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
        String pswd = request.getParameter("password");
        Connection con=null;
        PreparedStatement stmt=null;
        
       
        try{
        	
        	con=DbConnection.conn();
         stmt = con.prepareStatement("select * from login where UserId=? and Password=?");
         stmt.setString(1,request.getParameter("user"));
         stmt.setString(2,request.getParameter("password"));
         ResultSet rs = stmt.executeQuery();
         
         HttpSession session = request.getSession(true);
        
         RequestDispatcher dp=request.getRequestDispatcher("welcome1.jsp");
         
         if(rs.next()){
     
        	 dp.forward(request,response);
         }
         else {
         
         PrintWriter out=response.getWriter();
        
        
         out.println("<script type=\"text/javascript\">");
         out.println("alert('User Id or password incorrect');");
         out.println("</script>");
        
         RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
			rd.include(request, response);
          
        
         
         }
        }catch(Exception ex){
        System.out.println("Connection Error");
        }
	}

}
