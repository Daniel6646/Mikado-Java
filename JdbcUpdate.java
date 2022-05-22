package assignment.jdbc;
import java.sql.*;
public class JdbcUpdate
{
	public static void main(String args[])
	{
		try
		{
			//class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("update employee set salary = 15000 where id = 10");
			System.out.println("No. of rows affected =" +i);
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};