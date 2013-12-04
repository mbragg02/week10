package echo_service;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * An implementation of the Echo service
 * @author Michael
 *
 */
public interface EchoService extends Remote {
	
	/**
	 * Returns the same string passed as a parameter
	 * @param s A String
	 * @return The same String
	 * @throws RemoteException
	 */
	public String echo(String s) throws RemoteException;

}
