package assignment.jdbc;
import java.sql.*;
public class JdbcSelect
{
	public static void main(String args[])
	{
		try
		{
			//class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			while (rs.next())
			{
				for(int i=1; i<=cols; i++)
				{
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println(" ");
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};