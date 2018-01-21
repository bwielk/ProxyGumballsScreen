package gumballs;

import java.rmi.*;
import java.util.*;

public interface GumballMachineRemote extends Remote{
	public HashMap generateReport() throws RemoteException;
}
