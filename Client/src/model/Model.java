package model;

import maze.maze3d.*;

/**
 * <h1>Model</h1><p>
 * This interface is the model part of our MVP architecture</br>
 * used for manages the data, logic and rules of the client application</br>
  * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public interface Model {
	

	/**
	 * <h1>getDirPath</h1><p>
	 * <i><ul>void getDirPath(String path)<i><p>
	 * Display all files and folders in a given directory.
	 *
	 * @param path - the directory
	 */
	public void getDirPath(String path);
	
	
	/**
	 * <h1>generateMaze3D</h1><p>
	 * <i><ul>void generateMaze3D(String mazeName, int z, int x, int y)<i><p>
	 * Generate new Maze3D
	 * @param mazeName - the name of the maze
	 * @param z - zAxis dimension
	 * @param x - xAxis dimension
	 * @param y - yAxis dimension
	 */
	public void generateMaze3D(String mazeName, int z, int x, int y);
	
	
	/**
	 * <h1>crossSectionByDimention</h1><p>
	 * <i><ul>void crossSectionByDimention(int index, String crossSection,  String mazeName)<i><p>
	 * Generate a cross section of Maze3D by given cross section and index
	 * @param crossSection - the dimension
	 * @param index - the index of the maze
	 * @param mazeName - the name of the maze
	 */
	public void crossSectionByDimention(int index, String crossSection,  String mazeName);
	
	/**
	 * <h1>displayMaze</h1><p>
	 * <i><ul>void displayMaze(String mazeName)<i><p>
	 * Get a name of Maze3D and display it
	 * @param mazeName - the name of the maze to display
	 */
	public void displayMaze(String mazeName);

	/**
	 * <h1>saveMaze</h1><p>
	 * <i><ul>void saveMaze(String mazeName, String path)<i><p>
	 * Save Maze3D to given directory
	 * @param path - the directory to store the maze
	 */
	public void saveMaze(String path) ;
	

	/**
	 * <h1>loadMaze</h1><p>
	 * <i><ul>void loadMaze(String path) <i><p>
	 * Load Maze3D from a given directory.
	 * @param path - the directory of the stored maze
	 */
	public void loadMaze(String path) ;
	
	
	/**
	 * <h1>Solve maze</h1><p>
	 * <i><ul>void solveMaze(String mazeName, String alg)<i><p>
	 * Solve a given Maze3D with given search algorithm 
	 * @param mazeName - the maze to solve
	 * @param alg - the algorithm to solve the maze
	 */
	public void solveMaze(String mazeName, String alg);
	
	/**
	 * <h1>displaySolution</h1><p>
	 * <i><ul>void displaySolution(String mazeName)<i><p>
	 * Display the solution path of a given maze3D
	 * @param mazeName - The name of the maze
	 */
	public void displaySolution(String mazeName);
	
	/**
	 * <h1>displayMenu</h1><p>
	 * <i><ul>void displayMenu()<i><p>
	 * Display the menu 
	 */
	public void displayMenu();
	
	
	/**
	 *<h1>notifyMazeIsready</h1><p>
	 *<i><ul>void notifyMazeIsready()<i><p>
	 *Notify that the maze is ready
	 */
	public void notifyMazeIsready();
	
	/**
	 * <h1>Close</h1><p>
	 * <i><ul>void close()<i><p>
	 * Close the application,
	 * Close all open threads
	 */
	public void exit();
	
	/**
	 * <h1>start</h1><p>
	 * <i><ul>void start()<i><p>
	 * Start the connection to the server and the thread
	 * that listen to messages from the server
	 */
	public void start();
	
	/**
	 * <h1>close</h1><p>
	 * <i><ul>void close()<i><p>
	 * Close the connection to the server
	 */
	public void close();
	
	/**
	 * <h1>writeToServer</h1><p>
	 * <i><ul>void writeToServer(String command,Object data)<i><p>
	 * Write to the server a command and parameters/object.
	 * @param command - the command
	 * @param data - parameters/object
	 */
	public void writeToServer(String command,Object data);
	
	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(Command command)<i><p>
	 * Get a data from the HashMap by command key
	 * @param command
	 */
	public Object getCommandData(String command);
	
	/**
	 * <h1>getCurrentMaze</h1><p>
	 * <i><ul>Maze3D getCurrentMaze()<i><p>
	 * Return the the maze that generated
	 */
	public Maze3D getCurrentMaze();
	
	/**
	 * <h1>setCurrentMaze</h1><p>
	 * <i><ul>void getCurrentMaze()<i><p>.
	 * @param currentMaze the {@link Maze3D}
	 */
	public void setCurrentMaze(Maze3D currentMaze);
	
		


}
