package finger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FingerService extends Remote {

	/**
	 * A user "connects" to the server
	 * @return a String. Status of the users connection.
	 * @throws RemoteException
	 */
	public String connect(String user, String password) throws RemoteException;
	
	
	/**
	 * Shows all the users "connected" to the server.
	 * @return a String. All the "connected" users.
	 * @throws RemoteException
	 */
	public String getConnected() throws RemoteException;
}
