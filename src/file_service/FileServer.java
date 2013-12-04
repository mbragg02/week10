package file_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServer  extends UnicastRemoteObject implements FileService {

	private static final long serialVersionUID = 3772139342449074877L;

	protected FileServer() throws RemoteException {
		super();
		// empty constructor for this server.
	}

	@Override
	public String fileContents(String fileRoute, String fileName) throws RemoteException {
		
		StringBuilder result = new StringBuilder();
		
		System.out.println(fileRoute + File.separator + fileName);
		File file = new File(fileRoute + File.separator + fileName);
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null) {
//				System.out.println(line);
				result.append(line);
//				result.append("\n");
			}
			System.out.println(result.toString());
		} 
		catch (FileNotFoundException e) {
			String notFound = "File " + file + " does not exist in the current directory";
			result.append(notFound);
			System.out.println(notFound);
			return result.toString();
			

		} catch (IOException e) {
			e.printStackTrace();
			
		
		} finally {
			closeReader(fileReader);
			System.out.println(result.toString());
			
		}
		return result.toString();
		
		
		
	}
	
	
	private static void closeReader(Reader reader) { 
		try {
			if (reader != null) { 
				reader.close();
			}
		} catch (IOException ex) {

			ex.printStackTrace();
		}
	}

}
