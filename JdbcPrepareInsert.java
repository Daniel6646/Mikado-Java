package assignment.jdbc;
import java.sql.*;
public class JdbcPrepareInsert
{
	public static void main(String args[])
	{
		try
		{
			//class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			PreparedStatement pstmt = con.prepareStatement("Insert into employee values(?,?,?)");
			pstmt.setInt(1,6);
			pstmt.setString(2,"Tom");
			pstmt.setDouble(3,10000);
			int i = pstmt.executeUpdate();
			System.out.println("No. of rows affected =" +i);
			pstmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};