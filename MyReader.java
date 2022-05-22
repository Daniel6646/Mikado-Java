package assignment.io;
import java.io.*;
public class MyReader
{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fis = new FileInputStream("MyObject.dat");
			ObjectInputStream ois =new ObjectInputStream(fis);

			Object o = ois.readObject();
			System.out.println(o);
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
};