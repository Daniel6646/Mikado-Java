package assignment.rmi;
import java.rmi.*;
public class MyClient 
{
	public static void main(String args[])
	{
		System.out.println("Starting Client");
		System.out.println("Looking UP For Server Stub");
		try
		{
			MyInterface mi = (MyInterface)Naming.lookup("rmi://localhost:1099/mikado");
			//MyInterface mi = (MyInterface)Naming.lookup("rmi://localhost:2000/mikado");
			System.out.println("Got the Stub");
			System.out.println("Calling Remote Method");
			System.out.println(mi.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};