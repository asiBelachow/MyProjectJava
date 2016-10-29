package clienthandler;

import java.io.Closeable;
import java.net.Socket;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;

/**
 *  <h1>AbstractClientHandler</h1><p>
 *  This class defines the common functionality in order to handle</br>
 *  the request of clients.</br>
 *  This class extends the Observable class</br>
 *  and implements the {@link ClientHandler} and {@link Closeable} interfaces
 * 
 */
public abstract class AbstractClientHandler extends Observable  implements ClientHandler,Closeable{

	//------------------------------Data Members-------------------------//
	
	/*Hold the command and the parameters*/
	protected HashMap<String, Object> data;
	/*The socket of connected client*/
	protected Socket client;
	/*The id of connected client*/
	protected String clientId;
	/*The thred pool to run the request of the clients*/
	protected ExecutorService pool;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>AbstractClientHandler</h1><p>
	 * <i>AbstractClientHandler(Socket client,String clientId )<i><p>
	 * Instantiates a new AbstractClientHandler
	 * @param client - socket connection
	 * @param clientId - unique for every client
	 */
	public AbstractClientHandler(Socket client,String clientId ) {
		this.client = client;
		this.clientId = clientId;
		data = new HashMap<String, Object>();
	}
	
	//-----------------------------Setters and Getters-------------------//

	/**
	 * <h1> getClient</h1><p>
	 * <i><ul> Socket getClient()<i><p>
	 * Return the socket of the client
	 * @return socket
	 */
	public Socket getClient() {
		return client;
	}

	/**
	 * <h1>getClientId</h1><p>
	 * <i><ul>String getClientId()<i><p>
	 * Return the client id.
	 * @return String id
	 */
	public String getClientId() {
		return clientId;
	}
	
	//-------------------------Functionality-------------------------//
	
	@Override
	public abstract void handleClient();

	
	/**
	 * <h1>setCommandAndNotify</h1><p>
	 * <i><ul>void setCommandAndNotify(String command, Object data)<i><p>
	 * Insert the command and the parameters/Object to the HashMap
	 * and notify the Observers about the changes
	 * @param command - the command
	 * @param data - the parameters/object to pass
	 */
	public void setCommandAndNotify(String command, Object data) {
		this.data.put(command, data);
		setChanged();
		notifyObservers(command);
	}

	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(String command)<i><p>
	 * Return an object from the HashMap by given key
	 * @param command -  command
	 * @return the parameters/object
	 */
	public Object getCommandData(String command) {
		return data.get(command);
	}
	


}
