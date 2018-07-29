<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date"%>
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
<title>Delete Data</title>


</head>
<body>

<%
String str11=request.getParameter("name111");
System.out.print(str11);
String sql = "delete from member where FirstName='"+str11+"'";

DbConnection db = new DbConnection();
Connection con = db.conn();

PreparedStatement ps= con.prepareStatement(sql);

 ps.executeUpdate();

RequestDispatcher rd = request.getRequestDispatcher("/welcome1.jsp");
rd.forward(request, response);
%>


</body>
</html>