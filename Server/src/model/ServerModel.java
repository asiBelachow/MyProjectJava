package model;

import clienthandler.MyClientHandler;

	/**<h1>ServerModel</h1>
	 * This interface is the model part of our MVP architecture</br>
	 * define the functionality of the server
	 * @author Asi Belachow
	 * @version 1.0
	 * @since 2016-10-17
	 */
public interface ServerModel {
	
	
	/**
	 * <h1>start</h1><p>
	 * <i><ul>void start()<i><p>
	 * This method start the server socket to accept clients connections
	 * and forward the client to {@link MyClientHandler} to handle the client request
	 * @throws Exception - for problem with communication
	 */
	public void start() throws Exception;
	
	/**
	 * <h1>stop()</h1><p>
	 * <i><ul>void stop()<i><p>
	 * This method stop the server from accepting new connections and finish handling all connected clients
	 * @throws Exception - for problem with closing communication
	 */
	public void stop() throws Exception;
	
	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(String command)<i><p>
	 * Get a data from the HashMap by String key.
	 * @param command 
	 * @return the object/parameters
	 */
	public Object getCommandData(String command);
		
	/**
	 * <h1>disconnectClient</h1><p>
	 * <i><ul>void disconnectClient(String clientId)<i><p>
	 * This method disconnect client by client id
	 * @param clientId - unique id
	 */
	public void disconnectClient(String clientId);

}
