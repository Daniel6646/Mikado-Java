package assignment.io;

import java.io.*;
public class IODemo5
{
	public static void main(String args[])
	{
		try{
			/*
			FileInputStream fis = new FileInputStream("D:\\Students\\MOHIT\\JAVA\\FileInput.txt");
			//DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			*/
			FileReader fr = new FileReader("D:\\Students\\MOHIT\\JAVA\\FileInput.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			while((s=br.readLine())!= null)
			{
				System.out.println(s);
			}
			//System.out.println("Hi "+s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}