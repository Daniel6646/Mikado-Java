package assignment.chat;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
public class RMIChatServer1 extends UnicastRemoteObject implements ChatServerInterface1
{
	Vector<ClientInfo> v;
	String identity = "mikado";
	public RMIChatServer1() throws RemoteException
	{
		v = new Vector<ClientInfo>();
		try
		{
			LocateRegistry.createRegistry(1099);
			Naming.rebind(identity,this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		public void login(String name, ChatClientInterface1 ref)
		{
			ClientInfo ci = new ClientInfo(name,ref);
			v.add(ci);
			broadcastMsg(name+"  has logged In");
			broadcastList();
		}
		public void takeMsg(String msg)
		{
			broadcastMsg(msg);
		}
		public ChatClientInterface1 giveRef(String hisName)
		{
			ClientInfo ci = new ClientInfo(hisName,null);
			if(v.contains(ci))
			{
				int index = v.indexOf(ci);
				ci = v.get(index);
			}
			return ci.ref;
		}
		class ClientInfo
		{
			String name;
			ChatClientInterface1 ref;
			public ClientInfo(String name,ChatClientInterface1 ref)
			{
				this.name = name;
				this.ref = ref;
			}
			public boolean equals (Object o)
			{
				if(o instanceof ClientInfo)
				{
					return((ClientInfo)o).name.equals(name);
				}
				else
				{
					return false;
				}
			}
		}
		public void logout(String name)
		{
			v.remove(new ClientInfo(name,null));
			broadcastMsg(name+"  has logged out");
			broadcastList();
		}
		public void broadcastMsg(String msg)
		{
			Enumeration<ClientInfo> en = v.elements();
			while(en.hasMoreElements())
			{
				ClientInfo ci = en.nextElement();
				try
				{
					ci.ref.takeMsg(msg);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		public void broadcastList()
		{
			Vector<String> v2 = new Vector<>();
			Enumeration<ClientInfo> en = v.elements();
			while(en.hasMoreElements())
			{
				ClientInfo ci = en.nextElement();
				v2.add(ci.name);
			}
			Enumeration<ClientInfo> en1 = v.elements();
			while(en1.hasMoreElements())
			{
				ClientInfo ci = en1.nextElement();
				try
				{
					ci.ref.takeClientList(v2);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
public static void main(String args[])
	{
	try
		{
		new RMIChatServer1();
		}
		catch(Exception e)
			{
			System.out.println(e);
			}
	}
}