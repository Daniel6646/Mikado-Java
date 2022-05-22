package assignment.io;

public class IODemo3
{
	public static void main(String args[])
	{
		System.out.println("Enter your name");
		byte [] b = new byte[50];
		try{
			int i = System.in.read(b);
			String s = new String(b,0,i-2);
			System.out.println("Hi "+s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}