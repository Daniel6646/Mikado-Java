package assignment.chat;
import java.rmi.*;
public interface ChatServerInterface1 extends Remote
{
	public void login (String name,ChatClientInterface1 ref) throws RemoteException;
	public void takeMsg (String msg) throws RemoteException;
	public void logout (String name) throws RemoteException;
	public ChatClientInterface1 giveRef(String hisName) throws RemoteException;
}