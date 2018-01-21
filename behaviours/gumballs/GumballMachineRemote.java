package gumballs;

import java.rmi.*;
import java.util.*;

public interface GumballMachineRemote extends Remote{
	public String getLocation() throws RemoteException;
	public double getTotal() throws RemoteException;
	public int getCount() throws RemoteException;
	public State getState() throws RemoteException;
}
