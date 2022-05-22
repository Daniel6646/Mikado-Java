package assignment.jdbc;
import java.sql.*;
public class StoredAddB
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore","root","mikado");
			CallableStatement cst= con.prepareCall("{?=call AddBook(?,?,?,?)}");
			cst.setInt(2,2);
			cst.setString(3,"Professional C#");
			cst.setString(4,"Chrisitian Nagel");
			cst.setDouble(5,500);
			cst.registerOutParameter(1,Types.INTEGER);
			cst.execute();
			System.out.println(cst.getInt(1));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
