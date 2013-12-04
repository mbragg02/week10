package file_service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class FileClient {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Remote service = Naming.lookup("//127.0.0.1:1099/file");
		FileService fileService = (FileService) service;
		
		String file = fileService.fileContents(args[0], args[1]);
		
		System.out.println(file);

	}

}
