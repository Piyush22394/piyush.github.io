
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Connection.DbConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Data</title>
<link rel = "stylesheet" href="css/adminstyle.css">
</head>
<body>
<div>
<ul>
<li>
<a href="index.html"><img src="images/logo.png" alt="gym" style="height:35px; width:120px; "/></a></li>
 
			   <li><a href="index.html" style="margin-left: 700px;">Home</a></li>
			   <li><a href="about.html">About</a></li>
			   <li><a href="pricing.html">Pricing</a></li>
			   <li><a href="contact.html">Contact</a></li>
			   <li><a href="regbyadmin.html">Add Member</a></li>
			   
</ul>
</div>	


<%
String str1= request.getParameter("id");

String fname = request.getParameter("Firstname");
String lname = request.getParameter("Lastname");
String mob=request.getParameter("mobile");
String email = request.getParameter("email");
String ht =request.getParameter("height") ;
String wt =request.getParameter("weight") ;

String sql="update member set FirstName=?,LastName=?,MobNo=?,Email=?,Height=?,Weight=? where FirstName='"+str1+"' ";
//DbConnection db = new DbConnection();

Connection con = DbConnection.conn();

PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, fname);
ps.setString(2, lname);
ps.setString(3, mob);
ps.setString(4, email);
ps.setString(5, ht);
ps.setString(6, wt);

ps.executeUpdate();

RequestDispatcher rd = request.getRequestDispatcher("/welcome1.jsp");
rd.forward(request, response);

//response.sendRedirect("welcome1.jsp");
%>


</body>
</html>