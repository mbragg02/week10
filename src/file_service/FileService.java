package file_service;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface FileService extends Remote {

	public String fileContents(String fileRoute, String fileName) throws RemoteException;
	
}
