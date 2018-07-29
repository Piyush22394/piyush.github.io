package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException
	{
				
	}
	
	public static Connection conn() throws SQLException, ClassNotFoundException{
        Connection con;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdata", "root", "admin");
if(con==null)
{
	System.out.println("Null");
}
else
{
	System.out.println("Connection Created.");
}

return(con);

}
	}


