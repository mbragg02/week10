package date_service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer extends UnicastRemoteObject implements DateService {

	private static final long serialVersionUID = -5394724875362222641L;

	protected DateServer() throws RemoteException {
		super();
		// Nothing for this server
	}

	public String date() throws RemoteException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String timeStamp = dateFormat.format(date);
		
		System.out.println("Replied to some client saying '" + timeStamp + "'");

		
		return timeStamp;
	}

}
