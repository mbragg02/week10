package file_service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class FileServerLauncher {

	public static void main(String[] args) {
		launch();

	}

	private static void launch() {
		// 1: If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			// 2: Create the register if there is not one.
			LocateRegistry.createRegistry(1099);
			// 3: Create the server object
			FileServer server = new FileServer();
			// 4: Register (bind) the server object on the register 
			// Note. The register may be on a different machine
			String registryHost = "//localhost/";
			String serviceName = "file";
			Naming.rebind(registryHost + serviceName, server);

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}




}
