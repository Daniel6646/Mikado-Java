package assignment.jdbc;
import java.sql.*;
public class StoredAddC
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore","root","mikado");
			CallableStatement cst= con.prepareCall("{call AddCategory(?)}");
			cst.setString(1,"C#");
			cst.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
