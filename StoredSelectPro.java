package assignment.jdbc;
import java.sql.*;
public class StoredSelectPro
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore","root","mikado");
			CallableStatement cst= con.prepareCall("{ call SelectPro() }");
			ResultSet rs = cst.executeQuery();
			while(rs.next())
			{
			System.out.print(rs.getString(1));
			System.out.print(" "+rs.getString(2));
			System.out.println(" ");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
