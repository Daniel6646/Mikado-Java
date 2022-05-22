package assignment.chat;
import java.rmi.*;
public interface ChatServerInterface extends Remote
{
	public void login (String name,ChatClientInterface ref) throws RemoteException;
	public void takeMsg (String msg) throws RemoteException;
	public void logout (String name) throws RemoteException;
}