package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DbConnection;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/display.jsp");
		rd.include(req, res);
		String s = req.getParameter("name1");
System.out.println("S===>"+s);
		DbConnection db1=new DbConnection();
		Connection con1;
		
		try {
			con1 = db1.conn();
		
		Statement st1=con1.createStatement();
		String str1="select * from member where FirstName='"+s+"'";
		ResultSet rs1=st1.executeQuery(str1);
		PrintWriter out = res.getWriter();
		out.println("<table>");
		out.print("<tr><th>First Name</th><th>LastName</th><th>MobNo</th><th>Email</th><th>Gender</th><th>Height</th>");
		out.print("<th>Weight</th><th>RegDate</th><th>Enddate</th></tr>");
		
			while(rs1.next())
			{
				String fname1 = rs1.getString("FirstName");
		        String lname1 = rs1.getString("LastName");
		        String mob1 = rs1.getString("MobNo");
		        String eml1 = rs1.getString("Email");
		        String gen1 = rs1.getString("Gender");
		        String ht1= rs1.getString("Height");
		        String wt1 = rs1.getString("Weight");
		        Date regdate1 = rs1.getDate("RegDate");
		        Date enddate1 = rs1.getDate("EndDate");
		        //System.out.println(fname1+" "+lname1+""+mob1);
			
	out.print("<tr><td>"+fname1+"</td><td>"+lname1+"</td><td>"+mob1+"</td><td>"+eml1+"</td><td>"+gen1+"</td><td>"+ht1+"</td>");
	out.print("<td>"+wt1+"</td><td>"+regdate1+"</td><td>"+enddate1+"</td>");
		
		
			}
			out.println("</table>");
//			out.println("</body>");
//			out.println("</html>");
//			 RequestDispatcher rd = req.getRequestDispatcher("/display.jsp");
//				rd.include(req, res);
		
//		out.print("<html> <body><script>alert('al');</script></body></html>");
       
	}catch (Exception e) {
		
		e.printStackTrace();
	}
		}
	}
	


