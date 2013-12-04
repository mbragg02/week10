package date_service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class DateClient {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Remote service = Naming.lookup("//127.0.0.1:1099/date");
		DateService dateService = (DateService) service;
		
		String recievedDate = dateService.date();
		
		System.out.println(recievedDate);

	}


}
