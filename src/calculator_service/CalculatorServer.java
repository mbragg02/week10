package calculator_service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorService {

	private static final long serialVersionUID = 1218175672255299458L;

	protected CalculatorServer() throws RemoteException {
		super();
		// Empty constructor for the server.
	}

	public int add(int a, int b) throws RemoteException {
		int result = a + b;
		System.out.println("Performing addition");

		return result;
	}

	public int minus(int a, int b) throws RemoteException {
		int result = a - b;
		System.out.println("Performing minus");
		return result;
	}

	public int multiply(int a, int b) throws RemoteException {
		int result = a * b;
		System.out.println("Performing multiplication");
		return result;
	}

	public double division(int a, int b) throws RemoteException {
		double result = 1d * a / b;
		System.out.println("Performing division");
		return result;
	}

}
