package view;

import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;

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


	public void close();
	
	public void run();
	
	
	/**
	 *<h1>Display Message</h1><p>
	 * <i><ul>void displayMessage(String msg)<i><p>
	 * Get a message from the {@link Presenter} and view it to the user
	 * @param msg - the message
 	 */
	void displayMessage(String msg);
	
	/**
	 *<h1>Notify Maze Is Ready</h1><p>
	 * <i><ul>void notifyMazeIsReady(String name)<i><p>
	 * Get an event that notify the {@link View} about the</br> process of generating maze in the {@link Model}
	 * @param name - the name of the Maze3D
 	 */
	public void notifyMazeIsReady(String name);
	
	
	/**
	 *<h1>Notify Solution Is Ready</h1><p>
	 * <i><ul>void notifySolutionIsReady(String name)<i><p>
	 * Get an event that notify the {@link View} about the</br> process of solving maze in the {@link Model}
	 * @param name - the name of the Maze3D
 	 */
	public void notifySolutionIsReady(String name);
	
	

	
	/**
	 * <h1>Get Cross Section</h1><p>
	 * <i><ul>void getCrossSection(int[][] section)<i><p>
	 * Display a cross section of the maze.
	 * @param section - int[][] the cross section
	 */
	public void getCrossSection(int[][] section);
	
	
	/**
	 * <h1>Display Maze</h1><p>
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
	

	
	
	
	
	
}
