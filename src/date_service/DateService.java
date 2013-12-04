package date_service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An implementation of the Date service
 * @author Michael Bragg
 *
 */
public interface DateService extends Remote {
	
	/**
	 * Returns the current date
	 * @return A String. The current data
	 * @throws RemoteException
	 */
	public String date() throws RemoteException;

}
