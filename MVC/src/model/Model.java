package model;

import java.io.IOException;

import controller.Controller;

/**
 * <h1>The Interface Model</h1></br>
 * This interface is the model part of our MVC architecture</br>
 * used for manages the data, logic and rules of the application</br>
 * and forward solutions to the {@link Controller} 
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-05-09
 */
public interface Model {
	

	/**
	 * <h1>Get directory path</h1><p>
	 * <i><ul>void getDirPath(String path)<i><p>
	 * Display all files and folders in a given directory
	 * @param path - the directory
	 */
	public void dirPath(String path);
	
	
	/**
	 * <h1>Generate Maze3D</h1><p>
	 * <i><ul>void generateMaze3D(String mazeName)<i><p>
	 * Generate new Maze3D
	 * @param mazeName - the name of the maze
	 * @param z - zAxis dimension
	 * @param x - xAxis dimension
	 * @param y - yAxis dimension
	 */
	public void generateMaze3D(String mazeName, int z, int x, int y);
	
	
	/**
	 * <h1>Cross Section By Dimension</h1><p>
	 * <i><ul>void CrossSectionByDimention(String command, int index, String mazeName)<i><p>
	 * Generate a cross section of Maze3D by given cross section and index
	 * @param crossSection - the dimension
	 * @param index - the index of the maze
	 * @param mazeName - the name of the maze
	 */
	public void CrossSectionByDimention(int index, String crossSection,  String mazeName);
	
	
	/**
	 * <h1>Display maze 3D</h1><p>
	 * <i><ul>void displayMaze3D(String name)<i><p>
	 * Get a name of Maze3D and display it
	 * @param name - the name of the maze to display
	 */
	public void displayMaze(String name);

	/**
	 * <h1>Save Maze</h1><p>
	 * <i><ul>void saveMaze(String mazeName, String file)<i><p>
	 * Save Maze3D to given directory
	 * @param mazeName - the name of the maze
	 * @param file - the name of the file that will stored the maze
	 */
	public void saveMaze(String mazeName, String path) throws IOException;
	
	
	/**
	 * <h1>Load Maze</h1><p>
	 * <i><ul>void loadMaze(String file, String mazeName)<i><p>
	 * Load Maze3D from a given directory
	 * @param file - the name of the file 
	 * @param mazeName - the name for the loaded maze
	 */
	public void loadMaze(String file, String mazeName) throws IOException;
	
	
	/**
	 * <h1>Solve maze</h1><p>
	 * <i><ul>void solveMaze(String mazeName, String alg)<i><p>
	 * Solve a given Maze3D with given search algorithm 
	 * @param mazeName - the maze to solve
	 * @param alg - the algorithm to solve the maze
	 */
	public void solveMaze(String mazeName, String alg);
	
	
	/**
	 * <h1>Display Solution</h1><p>
	 * <i><ul>void displaySolution(String mazeName)<i><p>
	 * Display the solution path of a given name of maze
	 * @param mazeName - The name of the maze
	 */
	public void displaySolution(String mazeName);
	
	
	/**
	 * <h1>Display list of all mazes</h1><p>
	 * <i><ul>void displayListOfAllMaze()<i><p>
	 * Display the list of all mazes that created
	 */
	public void displayListOfAllMaze();
	
	

	/**
	 * <h1>Display Menu</h1><p>
	 * <i><ul>void displayMenu()<i><p>
	 * Display the menu of the command
	 */
	public void displayMenu();
	
	
	
	/**
	 * <h1>Close</h1><p>
	 * <i><ul>void close()<i><p>
	 * Close the application,
	 * Close all open threads
	 */
	public void close();
	
		


}
