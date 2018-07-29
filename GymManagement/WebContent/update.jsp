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

<title>Update</title>

<link rel = "stylesheet" href="css/adminstyle.css">
</head>
<body>

<div>
<ul>
<li>
<a href="index.html"><img src="images/logo.png" alt="gym" style="height:35px; width:120px; "/></a></li>
 
			   <li><a href="index.html" style="margin-left: 725px;">Home</a></li>
			   <li><a href="about.html">About</a></li>
			   <li><a href="pricing.html">Pricing</a></li>
			   <li><a href="contact.html">Contact</a></li>
			   <li><a href="regbyadmin.html">Add Member</a></li>
</ul>
</div>	

<h2>PERSONAL INFORMATION</h2>

<%
String str=request.getParameter("name11");

DbConnection db = new DbConnection();
Connection con = DbConnection.conn();
Statement st= con.createStatement();
String sql = "select * from member where FirstName='"+str+"'";
ResultSet rs = st.executeQuery(sql);
while(rs.next())
{  %>

<table align="center" style="width:20%">
<tr>
<td>

<form method="post" action="update-process.jsp">

<input type="hidden" name="id" value="<%=rs.getString("FirstName") %>">

										
										
											<span>First Name:</span>
											<td>
											<input type="text" name="Firstname" value="<%=rs.getString("FirstName")%>"> 
										</td>
										</td>
										</tr>
										
										<tr>
										<td>
											<span>Last Name:</span>
											<td>
											<input type="text" name="Lastname" value="<%=rs.getString("LastName")%>"> 
											</td>
											</td>
										</tr>
										<tr>
										<td>
										
											<span>Mobile:</span>
											<td>
											<input type="text" name="mobile" value="<%=rs.getString("MobNo")%>"> 
										</td>
										</td>
										</tr>
										<tr>
										<td>
											<span>Email Id:</span>
											<td>
											<input type="text" name="email" value="<%=rs.getString("Email")%>"> 
										</td>
										</td>
										</tr>
										
										<tr>
										<td>
											<span>Height(Cm):</span>
											<td>
											<input type="text" name="height" value="<%=rs.getString("Height") %>"> 
										</td>
										</td>
										</tr>
										<tr>
										<td>
											<span>Weight(Kg):</span>
											<td>
											<input type="text" name="weight" value="<%=rs.getString("Weight")%>"> 
											</td>
											</td>
											</tr>
											<tr>
											<td align="center">
										<input type="submit" value="Update">
										</td>
									</tr>

<% 
}
%>	


</td>
</tr>
</table>

</body>
</html>