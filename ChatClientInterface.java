package assignment.chat;
import java.rmi.*;
import java.util.*;
public interface ChatClientInterface extends Remote
{
	public void takeMsg (String msg) throws RemoteException;
	public void takeClientList (Vector <String> clients) throws RemoteException;
}