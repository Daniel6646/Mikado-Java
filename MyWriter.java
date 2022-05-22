package assignment.io;
import java.io.*;
public class MyWriter
{
	public static void main(String args[])
	{
		Employee emp=new Employee(1,"john",10000);
		try
		{
			FileOutputStream fos= new FileOutputStream("MyObject.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			System.out.println(emp);
			oos.writeObject(emp);
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
};