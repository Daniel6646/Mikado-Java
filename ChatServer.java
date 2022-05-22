package assignment.sockets;
import java.net.*;
import java.io.*;
import java.util.*;
 public class ChatServer
 {
	 ServerSocket server;
	 Vector v;
	 Thread type1;
	 public ChatServer()
	 {
		 v = new Vector ();
		 try
		 {
			 server = new ServerSocket(10000);
			 type1 = new Thread( new Runnable()
			 {
				 public void run()
				 {
					 while(true)
					 {
						 try
						 {
							 Socket client = server.accept();
							 DataInputStream dis =new DataInputStream (client.getInputStream());
							 PrintStream ps = new PrintStream (client.getOutputStream());
							 v.add(ps);
							 Type2Thread type2 = new Type2Thread(dis);
							 type2.start();
						 }
						 catch(Exception e)
						 {System.out.println(e);}
					 }
				 }});
				 type1.start();
		 }
		 catch(Exception e)
			 {System.out.println(e);}
	 }
	 public class Type2Thread extends Thread
	 {
		 DataInputStream dis;
		 public Type2Thread (DataInputStream dis)
		 {
			 this.dis = dis;
		 }
		 public void run()
		 {
			 while(true)
			 {
				 try
				 {
					 String msg = dis.readLine();
					 broadcast(msg);
				 }
				 catch (Exception e)
				 {
					 stop();
				 }
			 }
		 }
	 };
	 public void broadcast(String msg)
	 {
		 Enumeration en = v.elements();
		 while(en.hasMoreElements())
		 {
			 PrintStream ps = (PrintStream)en.nextElement();
			 ps.println(msg);
		 }
	 }
	 public static void main(String args[])
	 {
		 new ChatServer();
	 }
 };