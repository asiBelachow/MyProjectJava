package view;



/**
 * <h1>The Interface View</h1><p>
 * This interface is the view part of the MVP</br> architecture, used for different
 * implementations of UI

 * @author Asi Belachow
 * @version 1.0
 * @since 2016-10-09
 *
 */
public interface View {

	
	/**
	 *<h1>start</h1><p>
	 * <i><ul>void start()<i><p>
	 * Starts the server view
 	 */
	public void start();
	
	/**
	 *<h1>close</h1><p>
	 * <i><ul>void close()<i><p>
	 * Closes the server view
 	 */
	public void close();


	/**
	* <h1>addClient</h1><p>
	* <i><ul>void addClient(String[] client)<i><p>
	* Adds a client to the view
	* @param client - array in format: "client id,ip,current status,last requested command,command parameters,total number of commands"
	*/
	public void addClient(String[] client);
	
	/**
	 * <h1>removeClient</h1><p>
	 * <i><ul>void removeClient(String clientId)<i><p>
	 * Removes a client from the view.
	 * @param clientId - client id to remove
	 */
	public void removeClient(String clientId);
	
	/**
	 * <h1>displayInConsole</h1><p>
	 * <i><ul>void displayInConsole(String str)<i><p>
	 * display a message to the console (however implemented)
	 * @param str - message to display
	 */
	public void displayInConsole(String str);
	
	/**
	 * <h1>updateClient</h1><p>
	 * <i><ul>void updateClient(String[] fields)<i><p>
	 * Updates an existing client in the view(fields[0] is used to find the
	 * @param fields - fields client fields based on addClient's format
	 */
	public void updateClient(String[] fields);
	
	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(Command command)<i><p>
	 * Get a data from the HashMap by command key
	 * @param command
	 */
	public Object getCommandData(String command);

	
	/**
	 * <h1>serverStoppedEventHandler()</h1><p>
	 * <i><ul>void serverStoppedEventHandler()<i><p>
	 * Change the button when server stopped
	 * @param command
	 */
	public void serverStoppedEventHandler();

	/**
	 * <h1>serverStartedEventHandler</h1><p>
	 * <i><ul>void serverStartedEventHandler()<i><p>
	 * Change the button when server started
	 * @param command
	 */
	public void serverStartedEventHandler();
	
	/**
	 * <h1>serverErrorEventHandler()</h1><p>
	 * <i><ul>void serverErrorEventHandler()<i><p>
	 * Change the button when error occurred while trying stop the server
	 * @param command
	 */
	public void serverErrorEventHandler();
	
	/**
	 *<h1>displayMessage</h1><p>
	 * <i><ul>void displayMessage(String msg)<i><p>
	 * Get a message from the {@link Presenter} and view it to the user
	 * @param msg - the message
 	 */
	void displayMessage(String msg);

	
	
}
