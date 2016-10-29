package commands;

import java.io.IOException;

/**
 * <h1>The Interface Command.</h1><p>
 * The interface Command define the required methods in order to execute command
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-09-05
 */
public interface Command {
	
	/**
	* <h1>Do commmand.</h1><p>
	* <i><ul>void doCommmand(String[] param)<i><p>
	* This method define the ability to execute a command
	* @param param - the parameters that the client entered
	* @throws IOException Signals that an I/O exception has occurred.
	*/
	public void doCommmand(String[] param) throws IOException;

	@Override
	public String toString();
}
