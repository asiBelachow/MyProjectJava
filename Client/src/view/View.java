package view;

import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;
import commands.Command;

/**
 * <h1>View</h1><p>
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
	 * Starts the client view
 	 */
	public void start();
	
	/**
	 *<h1>close</h1><p>
	 * <i><ul>void close()<i><p>
	 * Closes the client view
 	 */
	public void close();
	
	/**
	 *<h1>displayMessage</h1><p>
	 * <i><ul>void displayMessage(String msg)<i><p>
	 * Get a message from the {@link Presenter} and view it to the user
	 * @param msg - the message
 	 */
	void displayMessage(String msg);
	
	/**
	 *<h1>notifyMazeIsReady</h1><p>
	 * <i><ul>void notifyMazeIsReady(String name)<i><p>
	 * Get an event that notify the {@link View} about the</br> process of generating maze in the {@link Model}
	 * @param name - the name of the Maze3D
 	 */
	public void notifyMazeIsReady(String name);
	
	
	/**
	 *<h1>notifySolutionIsReady</h1><p>
	 * <i><ul>void notifySolutionIsReady(String name)<i><p>
	 * Get an event that notify the {@link View} about the</br> process of solving maze in the {@link Model}
	 * @param name - the name of the Maze3D
 	 */
	public void notifySolutionIsReady(String name);
	

	/**
	 * <h1>getCrossSection</h1><p>
	 * <i><ul>void getCrossSection(int[][] section)<i><p>
	 * Display a cross section of the maze.
	 * @param section - int[][] the cross section
	 */
	public void getCrossSection(int[][] section);
	
	
	/**
	 * <h1>displaySolution</h1><p>
	 * <i><ul>void displayMaze(Maze3D maze)<i><p>
	 * Display a maze3D 
	 * @param maze - Maze3D
	 */
	public void displayMaze(Maze3D maze);

	
	/**
	 * <h1>Display Solution</h1><p>
	 * <i><ul>void displaySolution(Solution<Position3D> solution)<i><p>
	 * Display a solution 
	 * @param solution 
	 */
	public void displaySolution(Solution<Position3D> solution);
	
	/**
	 * <h1>resetGameEvetHandler</h1><p>
	 * <i><ul>void resetGameEvetHandler()<i><p>
	 * Reset widgets after game solved
	 */
	public void resetGameEvetHandler();

	/**
	 * <h1>writeToConsole</h1><p>
	 * <i><ul>void writeToConsole(String msg)<i><p>
	 * display a message to the console (however implemented)
	 * @param msg - message to display
	 */
	public void writeToConsole(String msg);
	
	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(Command command)<i><p>
	 * Get a data from the HashMap by command key
	 * @param command
	 */
	public Object getCommandData(Command command);
	
	/**
	 * <h1>connectToServerEventHandler</h1><p>
	 * <i><ul>void connectToServerEventHandler()<i><p>
	 * Initialize the buttons after connecting to server
	 */
	public void connectToServerEventHandler();
	
	/**
	 * <h1>disconnectFromServerEventHandler</h1><p>
	 * <i><ul>void disconnectFromServerEventHandler()<i><p>
	 * Initialize the buttons after disconnecting from server
	 */
	public void disconnectFromServerEventHandler();
	
}
