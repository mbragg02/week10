package finger;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FingerServer extends UnicastRemoteObject implements FingerService {

	private static final long serialVersionUID = 8366139378832222652L;
	private ArrayList<User> users;

	/**
	 * Constructor. Creates the list of valid users. 
	 * @throws RemoteException
	 */
	protected FingerServer() throws RemoteException {
		super();
		this.users = new ArrayList<User>(); 
		setValidUsers();
		System.out.println("User server statred... ");

	}
	
	/**
	 * Create the valid users for the system
	 */
	private void setValidUsers() {
		User admin = new User("admin", "master");
		User michael = new User("michael", "password");
		User sam = new User("sam", "password");
		users.add(admin);
		users.add(michael);
		users.add(sam);
	}
	

	

	/**
	 * Method to validate the user attempting to log onto the server.
	 * If valid - Set there logged on status to true.
	 * @param user String. The supplied username.
	 * @param password String. The supplied users password.
	 * @return result String. The connection status message for the given user.
	 * @throws RemoteException 
	 */
	@Override
	public String connect(String user, String password) throws RemoteException {
		String result = null;
		String connectedAt = getDate();
		User connectUser = isValidUser(user, password);
		
		if(connectUser != null) {
			if(!isConnectedUser(connectUser)) {

				connectUser.setConnectedAt(connectedAt);
				connectUser.setLoggedIn(true);
				result = user + " connected at " + connectedAt;
			} else {
				result = user + " already logged onto the server";
			}
			
		} else {
			result = "Either " + user + " is not a valid user or your password is oncorrect";
		}

		System.out.println(result);
		return result;
	}
	
	/**
	 * Method to check the supplied user us on the system
	 * @param user String. The users name
	 * @param password String. The users password
	 * @return User object if valid. Otherwise Null.
	 */
	private User isValidUser(String user, String password) {
		for (User u : users) {
			if(u.getName().equals(user)) {
				if (isValidPassword(u, password)) {
					return u;
				}
					
			}
		}
		
		return null;
	}
	
	/**
	 * Method to check the validated user name has the correct password.
	 * @param u User object. Has a valid user name.
	 * @param password String. The supplied password.
	 * @return True or false.
	 */
	private boolean isValidPassword(User u, String password) {
		if (u.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if a user is already logged onto the system.
	 * @param user User object to check.
	 * @return true or false.
	 */
	private boolean isConnectedUser(User user) {
		return user.isLoggedIn();
	}
	
	/**
	 * Method to get the current date and time formated.
	 * @return String. The formated current date and time. "yyyy/MM/dd HH:mm:ss"
	 */
	private String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		String result = dateFormat.format(date);
		return result;
	}
	
	
	/**
	 * Method to display all the currently logged on users on the server.
	 * @return String. The currently logged on users.
	 * @throws RemoteException
	 */
	@Override
	public String getConnected() throws RemoteException {
		StringBuffer buffer = new StringBuffer();

		// Display contents of users
		buffer.append("Users currently logged into the server \n");
		System.out.println("Logged on users resuested");

		for (int i = 0; i < users.size(); i ++) {
			if (users.get(i).isLoggedIn()) {
				buffer.append(users.get(i).getName() + " connected at " + users.get(i).getConnectedAt());
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}





}
