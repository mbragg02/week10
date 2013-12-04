package calculator_service;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CalculatorService extends Remote {
	
	public int add(int a, int b) throws RemoteException;
	
	public int minus(int a, int b) throws RemoteException;
	
	public int multiply(int a, int b) throws RemoteException;
	
	public double division(int a, int b) throws RemoteException;

}
