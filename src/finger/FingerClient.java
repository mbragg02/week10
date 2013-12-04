package finger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class FingerClient {
	
	/**
	 * Prints out all the currently logged on users.
	 * @param args none
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Remote service = Naming.lookup("//127.0.0.1:1099/finger");
		FingerService fingerService = (FingerService) service;
		
		
		String result = fingerService.getConnected();
		
		System.out.println(result);

	}

}
