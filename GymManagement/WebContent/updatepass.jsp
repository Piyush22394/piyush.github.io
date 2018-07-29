<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="Connection.DbConnection"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password  </title>
</head>
<body>
<%
String e = (String) session.getAttribute("Email");
String p = (String) session.getAttribute("pass");
System.out.println("Updated pass===>"+p);
%>

<%
String sql = "Update login set Password=? where Email='"+e+"'";
Connection con = DbConnection.conn();
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, p);

ps.executeUpdate();

RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
rd.forward(request, response);
%>
</body>
</html>