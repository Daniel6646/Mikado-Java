package assignment.io;

import java.io.*;
public class IODemo4
{
	public static void main(String args[])
	{
		System.out.println("Enter your name");
		//DataInputStream dis = new DataInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			//String s = dis.readLine();
			String s = br.readLine();
			System.out.println("Hi "+s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}