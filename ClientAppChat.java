package assignment.sockets;
import java.net.*;
import java.io.*;
public class ClientAppChat
{
	public static void main (String args[])
	{
		System.out.println("Starting Client App");
		System.out.println("Attempting Connection");
		try
		{
			Socket server = new Socket("localhost",11000);
			System.out.println("Connection Extablished");
			DataInputStream dis = new DataInputStream (server.getInputStream());
			PrintStream ps =new PrintStream (server.getOutputStream());
			DataInputStream local = new DataInputStream (System.in);
			while(true)
			{
			String s = local.readLine();
			ps.println(s);
			if(s.equalsIgnoreCase("bye"))
				break;
			String s1 = dis.readLine();
			System.out.println("Server: "+ s1);
			if(s.equalsIgnoreCase("bye"))
				break;
			}
			Thread.sleep(200);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};