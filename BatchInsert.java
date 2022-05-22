package assignment.jdbc;
import java.sql.*;
public class BatchInsert
{
	public static void main (String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			Statement stmt= con.createStatement();
			stmt.addBatch("insert into employee values(1,'sunil',6000)");
			stmt.addBatch("insert into employee values(2,'Deepak',8000)");
			stmt.addBatch("insert into employee values(3,'Bharat',6000)");
			con.setAutoCommit(false);
			int i[] = stmt.executeBatch();
			con.commit();
			//con.rollback();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};