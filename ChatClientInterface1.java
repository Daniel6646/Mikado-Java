package assignment.chat;
import java.rmi.*;
import java.util.*;
public interface ChatClientInterface1 extends Remote
{
	public void takeMsg (String msg) throws RemoteException;
	public void takeClientList (Vector <String> clients) throws RemoteException;
	public void pm(String hisName,ChatClientInterface1 hisRef,String hisMsg)throws RemoteException;
}