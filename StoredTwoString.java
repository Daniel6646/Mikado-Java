package assignment.jdbc;
import java.sql.*;
public class StoredTwoString
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore","root","mikado");
			CallableStatement cst= con.prepareCall("{ call twoOutputs(?,?)}");
			cst.registerOutParameter(1,Types.INTEGER);
			cst.registerOutParameter(2,Types.DOUBLE);
			cst.execute();
			System.out.println("Total No.of Books="+cst.getInt(1));
			System.out.println("Average Price of a book="+cst.getDouble(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
