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
<title>Admin Login</title>

<link rel = "stylesheet" href="css/adminstyle.css">

<script type="text/javascript">
function ConfirmDelete() //confirm where you wan to delete or not
{
    var Delet_Confirm= confirm("Do you really want to delete this record ?");
 if (Delet_Confirm== true)
 {
   return true;
 }
 else
 {
  return false;
  }
}
</script>

</head>
 
<body>

<div>
<ul>
<li>
<a href="index.html"><img src="images/logo.png" alt="gym" style="height:35px; width:120px; "/></a></li>

			   <li><a href="index.html" style="margin-left: 650px;">Home</a></li>
			   <li><a href="about.html">About</a></li>
			   <li><a href="pricing.html">Pricing</a></li>
			   <li><a href="contact.html">Contact</a></li>
			   <li><a href="regbyadmin.html">Add Member</a></li>
			   <li><a href="logout.jsp">SignOut</a></li>
			   
</ul>
</div>	
<div>
<!-- <img src="images/logo.png" alt="gym"/> -->
<h1> Admin's Page  </h1>

</div>

<table><!-- To display data in table -->
							
							<tr>
							<th>
							First name
							</th>
							<th>
							Last name
							</th>
							<th>
							Mobile No.
							</th>
							<th>
							Email
							</th>
							<th>
							Gender
							</th>
							<th>
							Height
							</th>
							<th>
							Weight
							</th>
							<th>
							Registration date
							</th>
							<th>
							End Date
							</th>
							</tr>
												
							
							<%
							DbConnection db=new DbConnection();
							Connection con=db.conn();
							Statement st=con.createStatement();
							String str="select * from member order by FirstName";
							ResultSet rs=st.executeQuery(str);
							while(rs.next())
							{
								String fname = rs.getString("FirstName");
				                String lname = rs.getString("LastName");
				                String mob = rs.getString("MobNo");
				                String eml = rs.getString("Email");
				                String gen = rs.getString("Gender");
				                String ht = rs.getString("Height");
				                String wt = rs.getString("Weight");
				                Date regdate = rs.getDate("RegDate");
				                Date enddate = rs.getDate("EndDate");
							%>
							
							<tr>
							<td><%=fname %></td>
							<td><%=lname %></td>
							<td><%=mob %></td>
							<td><%=eml %></td>
							<td><%=gen %></td>
							<td><%=ht %></td>
							<td><%=wt %></td>
							<td><%=regdate %></td>
							<td><%=enddate %></td>
							</tr>
							
							<%
							}
							%>
			</table><!-- End of table -->
							

<table >
<tr>
<td>
<form action="display.jsp" method="post">
Search:<input type="text" name="name1" placeholder="Enter name to Search">
<input type="submit" value="Search"/>
</form>
</td>
</tr>

<tr>
<td>
<form action="update.jsp" method="post">
Update:<input type="text" name="name11" placeholder="Enter name to Update">
<input type="submit" value="Update"/>
</form>
</td>
<tr>

<tr>
<td>
<form action="delete.jsp" method="post" onsubmit="return ConfirmDelete();"> 
Delete:<input type="text" name="name111" placeholder="Enter name to Delete">
<input type="submit" value="Delete"/>
</form>

</td>
</tr>
</table>




</body>
</html>