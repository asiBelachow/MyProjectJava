package allCommands;

import java.io.IOException;

import model.Model;

/**
 * <h1>The Class ClientCommands</h1><p>
 * The Class ClientCommands define the common functionality of</br>
 * commands that the client can perform
 * <b>Data members:</b>
 * <ul>
 * <li> m - the {@link Model}
 * </ul>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-09-05
 */

public abstract class ClientCommands implements Command {
	
	//------------------------------Data Members-------------------------//
	
	Model m;
	
	
	//-------------------------Constructors-------------------------//
	
	/**
	 *<h1>Client Commands</h1><p>
	 * <i><ul>ClientCommands(Model m)<i><p>
	 * Initialize a new Controller
	 * @param m - the {@link Model}
	 */
	public ClientCommands(Model m) {
		this.m = m;
	}

	@Override
	public abstract void doCommmand(String[] param) throws IOException;
		
	@Override
	public abstract String toString();

	


}
