package model;

import algorithms.search.Solution;
import maze.maze3d.Maze3D;
import position.position3d.Position3D;


/**
 * <h1>Model</h1><p>
 * This interface define the functionality in order to execute the user requests
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public interface Model {
	

	
	/**
	 * <h1>generateMaze3D</h1><p>
	 * <i>void generateMaze3D(String mazeName, int z, int x, int y)<i><p>
	 * Generate a new {@link Maze3D} object
	 * @param mazeName - the name of the maze
	 * @param z - zAxis
	 * @param x - xAxis
	 * @param y - yAxis
	 */
	public void generateMaze3D(String mazeName, int z, int x, int y);
	
	
	/**
	 * <h1>getMaze</h1><p>
	 * <i>Maze3D getMaze(String name)<i><p>
	 * Get a maze from the cached maze
	 * @param name - the name of the maze
	 */
	public Maze3D getMaze(String name);
	
	/**
	 * <h1>getCommandData</h1><p>
	 * <i><ul>Object getCommandData(String command)<i><p>
	 * Get a data from the HashMap by String key.
	 * @param command 
	 * @return the object/parameters
	 */
	public Object getCommandData(String command);
	
	/**
	 * <h1>solveMaze3D</h1><p>
	 * <i>void solveMaze3D(String mazeName, String alg)<i><p>
	 * Solve a maze3D by given algorithm.
	 * @param mazeName - the maze name
	 * @param alg - algorithm to solve the maze
	 */
	public void solveMaze3D(String mazeName, String alg);
	
	/**
	 * <h1>getSolution</h1><p>
	 * <i> Solution<Position3D> getSolution(String name)<i><p>
	 * Show solution of a maze3D
	 * @param name - the maze name
	 * @return Solution<Position3D> 
	 */
	public Solution<Position3D> getSolution(String name);
	
	
	
}
