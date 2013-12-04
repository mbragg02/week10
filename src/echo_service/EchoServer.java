package echo_service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer extends UnicastRemoteObject implements EchoService {

	private static final long serialVersionUID = -7147506283985914318L;

	protected EchoServer() throws RemoteException {
		super();
		// Nothing to initialize for this server.
	}

	@Override
	public String echo(String s) {
		// The println is not necessary but helps to verify that the server has received the call.
		System.out.println("Replied to some client saying '" + s + "'");
		return s;
	}

}
