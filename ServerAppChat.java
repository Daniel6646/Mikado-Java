package assignment.sockets;
import java.net.*;
import java.io.*;
public class ServerAppChat
{
	public static void main (String args[])
	{
		System.out.println("Starting Server App");
		System.out.println("Instantiating ServerSocket");
		try
		{
			ServerSocket server = new ServerSocket(11000);
			System.out.println("Server is up");
			System.out.println("Waiting for Client Connection");
			Socket client = server.accept();
			System.out.println("Client Established Connection");
			DataInputStream dis = new DataInputStream (client.getInputStream());
			PrintStream ps =new PrintStream (client.getOutputStream());
			DataInputStream local = new DataInputStream (System.in);
			while(true)
			{
			String s = dis.readLine();
			System.out.println("Client: "+ s);
			if(s.equalsIgnoreCase("bye"))
				break;
			String s1 = local.readLine();
			ps.println(s1);
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