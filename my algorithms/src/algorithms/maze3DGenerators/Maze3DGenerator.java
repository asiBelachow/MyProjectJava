package algorithms.maze3DGenerators;




/**
 * The Interface Maze3dGenerator.
 * 
 * This interface define the algorithms to build 3d maze 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public interface Maze3DGenerator {
	
	/**
	 
	 * <h1><i>generate<i></h1><p>
	 * <i> <ul>public Maze3D generate(int zAxis,int xAxis, int yAxis)<i><p>
	 * This method is used to create 3d maze that represented by int[][][]
	 * <ul>
	 * <li>Initialization the 3d maze
	 * <li>Create the entrance to the maze
	 * <li>Create the exit of the maze
	 * <li>Promising path from entrance to end
	 * </ul>
	 *	<p>
	 * @param zAxis - the maze's Z dimension.
	 * @param xAxis - the maze's X dimension.
	 * @param yAxis - the maze's Y dimension.
	 * @return Maze3d object
	 */
	public Maze3D generate(int zAxis,int xAxis, int yAxis);
	
	/**
	 * <h1>Measure algorithm time</h1>
	 *  * <i> <ul>public Maze3D generate(int zAxis,int xAxis, int yAxis)<i><p>
	 * This method measure the time it takes to the algorithm to build the maze with
	 * entrance,exit and path between them
	 *<p>
	 *use generate method {@link #generate(int, int, int)} in order to build the maze
	 * @param zAxis - the maze's Z dimension.
	 * @param xAxis - the maze's Z dimension.
	 * @param yAxis - the maze's Y dimension.
	 * @return String - the time it's take to create the maze<p>
	 *<b>Note:</b>Time in millisecond
	 */
	public String measureAlgorithmTime(int zAxis,int xAxis, int yAxis);

}
