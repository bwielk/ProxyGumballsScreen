package gumballs;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
	
	public MyRemoteImpl() throws RemoteException {};
	
	public String sayHello(){
		return "Server says 'Hey'";
	}{try{
		MyRemote service = new MyRemoteImpl();
		Naming.rebind("Hello service", service);
	}catch(Exception ex){};
	}
}
