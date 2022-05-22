package assignment.rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class MyServer extends UnicastRemoteObject implements MyInterface
{
	String identity = "mikado"; 
	//String identity = "rmi://localhost:2000/mikado";
	public MyServer() throws RemoteException
	{
		System.out.println("Starting Server");
		System.out.println("Starting RMI registry");
		try
		{
			LocateRegistry.createRegistry(1099);
			//LocateRegistry.createRegistry(2000);
			System.out.println("Registry Started");
			System.out.println("Binding Stub");
			Naming.rebind(identity,this);
			System.out.println("Stub bound");
			System.out.println("Waiting for Client calls");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		public String getMessage()
		{
			return "Hello Client";
		}
		public static void main (String args[])
	{
			try
			{
				new MyServer();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
};