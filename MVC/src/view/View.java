package view;

import java.io.IOException;

import controller.Controller;



/**
 * * <h1>The Interface View</h1><p>
 * This interface is the view part of our MVC architecture</br>
 * used for displaying solution to the client and  </br>
 * forwarding commands to the {@link Controller} 
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-05-09
 *
 */
public interface View {
	
	public void start();
	/**
	 * <h1>Forward Command<h1>
	 * <i><ul>void forwardCommand(String command, String[] param)<i><p>
	 * Forward a command to the controller
	 * @param String - the command
	 * @param param - the parameters of the command
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void forwardCommand(String command, String[] param) throws IOException;
	
	
	
	/**
	 *<h1> Display solution.<h1>
	 * <i><ul>void displaySolution(String solution)<i><p>
	 * Get a solution from the controller and forward it to the client 
	 * @param String - the solution
 	 */
	public void displaySolution(String solution);
	
	

}
