package assignment.jdbc;
import java.sql.*;
public class ScrollResult
{
	public static void main (String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			while(rs.next())
			{
				for(int i = 1; i <= cols;i++)
				{
					System.out.print(rs.getString(i)+"\t ");
				}
				System.out.println(" ");
			}
			//updateable ResultSet
		/*	rs.absolute(2);
			rs.updateString("Name","Sujata");
			rs.updateRow();
			*/
			//updateable resultset
		rs.absolute(2);
			System.out.println("Name of employee in 2nd row = "+rs.getString(2));
			System.out.println("change in the backend and press enter");
			System.in.read();
			System.out.println("Name of employee in 2nd row now="+rs.getString(2));
	}
	catch(Exception e)
		{
			System.out.println(e);
		}
}
}