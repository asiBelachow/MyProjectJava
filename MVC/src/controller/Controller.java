package controller;


import view.View;

import java.io.IOException;


import model.Model;

/**
 * <h1>The Interface Controller</h1><p>
 * Controller interface define the functionality that needed in order <br>
 * to transfer orders commands and solution between the view and the model <br>
 * Perform decoupling between the {@link Model} and the {@link View}
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-05-09
 */
public interface Controller {
	
	/**
	 * <h1>Set model</h1><p>
	 * <i><ul>void setModel(Model m)<i><p>
	 * Set the data member {@link Model} m
	 * @param m - the  model
	 */
	public void setModel(Model m);
	
	
	/**
	 * <h1>Set view</h1><p>
	 * <i><ul>void setView(View v)<i><p>
	 * Set the data member {@link View} v
	 * @param v - the view 
	 */
	public void setView(View v);
	
	/**
	 * <h1>Forward command.</h1><p>
	 * <i><ul>void forwardCommand(String command,String[] param)<i><p>
	 * Forward the command and parameters to the {@link Model}</br>
	 * to do all the calculation
	 * @param command - the command to forward
	 * @param param - the parameters to forward
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void forwardCommand(String command,String[] param) throws IOException;

	/**
	 * <h1>Sets the solution</h1><p>
	 * <i><ul>void setSolution(String solution)<i><p>
	 * Forward the solution to the {@link View}
	 * @param solution - the solution 
	 */
	public void setSolution(String solution);
		

	
}
