package protocol;

import java.io.Serializable;

/**
 * <h1>Class CommandProtocol</h1>
 * This class is used to communicate with the server.
 * It uses a command(String) - simple hint of what is being sent
 * data (Object) - the data of the command itself
 * used in writeObject readObject in the different socket connections
 */
public class CommandProtocol implements Serializable {

	private static final long serialVersionUID = -8633300940276952792L;

	/** The command. */
	private String command;
	
	/** The parameters/object */
	private Object data;
	
	/**
	 * <h1>CommandProtocol</h1><p>
	 * <i><ul>CommandProtocol(String command,Object data) <i><p>
	 * Initialize a new command manger with command and data
	 * @param command - the command
	 * @param data - the parameters/object
	 */
	public CommandProtocol(String command,Object data) {
		this.command = command;
		this.data = data;
	}
	
	/**
	 * <h1>CommandProtocol</h1><p>
	 * <i><ul>CommandProtocol() <i><p>
	 * Initialize a new command manger - default constructor
	 */
	public CommandProtocol() {
		command = "";
		data = null;
	}

	/**
	 * <h1>getCommand</h1><p>
	 * <i><ul>String getCommand()<i><p>
	 * Get the command.
	 * @return String command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * <h1>setCommand</h1><p>
	 * <i><ul>void setCommand(String command)<i><p>
	 * Set the command.
	 * @param command - the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * <h1>getData</h1><p>
	 * <i><ul>Object getData()<i><p>
	 * Get the command.
	 * @return data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <h1>setData</h1><p>
	 * <i><ul>void setData(Object data)<i><p>
	 * Set the command.
	 * @param data - the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	

}
