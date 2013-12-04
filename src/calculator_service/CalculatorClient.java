package calculator_service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class CalculatorClient {
	


		public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
			Remote service = Naming.lookup("//127.0.0.1:1099/calculator");
			CalculatorService calculatorService = (CalculatorService) service;
			
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			int additionResult = calculatorService.add(a, b);
			int minusResult = calculatorService.minus(a, b);
			int multiplicationResult = calculatorService.multiply(a, b);
			double divisionResult = calculatorService.division(a, b);
			System.out.println(a + " + " + b + " = " + additionResult);
			System.out.println(a + " - " + b + " = " + minusResult);
			System.out.println(a + " * " + b + " = " + multiplicationResult);
			System.out.printf(a + " / " + b + " = " + "%.2f\n", divisionResult);

		}
		


	

}
