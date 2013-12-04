package finger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class LoginClient {

	/**
	 * Prints out the status of the attempted user connection. 
	 * Either that a user has connected to the server successfully or some other message.
	 * @param args none
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Remote service = Naming.lookup("//127.0.0.1:1099/finger");
		FingerService fingerService = (FingerService) service;
		
		String username = args[0];
		String password = args[1];

		String result = fingerService.connect(username, password);
		
		System.out.println(result);

	}

}
