package finger;

/**
 * A class to hold information about a user object. 
 * @author Michael
 *
 */
public class User {
	private String name;
	private String password;
	private String connectedAt;
	private boolean loggedIn;
	
	public User(String name, String password) {
		setName(name);
		setPassword(password);
		setConnectedAt(null);
		setLoggedIn(false);
	}
	
	/**
	 * Check if a user is logged in.
	 * @return boolean
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Set a users logged in status
	 * @param loggedIn boolean
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * Return a users name
	 * @return String. Their name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the date and time they connected
	 * @return String. The connection date and time
	 */
	public String getConnectedAt() {
		return connectedAt;
	}

	/**
	 * Set the connection date and time
	 * @param connectedAt String. The connection date and time
	 */
	public void setConnectedAt(String connectedAt) {
		this.connectedAt = connectedAt;
	}
	
	/**
	 * Set the users name
	 * @param name String. The users name
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the users password
	 * @param password String. The users password
	 */
	private void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Return the users password.
	 * @return String. The users password.
	 */
	public String getPassword() {
		return password;
	}
	
	

}
