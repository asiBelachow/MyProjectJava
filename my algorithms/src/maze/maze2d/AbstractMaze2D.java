package maze.maze2d;

import java.util.ArrayList;

import maze.AbstractMaze;
import position.position2d.Position2D;



/** 
 * The Class define the common functionality of Maze2D
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class AbstractMaze2D extends AbstractMaze {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363077378548364036L;

	@Override
	public abstract boolean equals(Object arg);

	@Override
	public abstract String toString();


	/**
	 * <h1>Get Value By Index</h1><p>
	 * <i><ul>int getValueByIndex(int x ,int y)<i><p>
	 * get a position (by xaxis and yaxis) in the maze and return it's value.
	 * @param x - the xAxis
	 * @param y - the yAxis
	 * @return the value
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public abstract int getValueByIndex(int x ,int y) throws IndexOutOfBoundsException;
	
	
	/**
	 * <h1>Get Value By Index</h1><p>
	 * <i><ul>int getValueByIndex(Position2D p)<i><p>
	 * get a position in the maze and return it's value.
	 * @param p - Position in the maze
	 * @return the value
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public abstract int getValueByIndex(Position2D p)throws IndexOutOfBoundsException;
	
	
	/**
	 * <h1>Set Value By Index</h1><p>
	 * <i><ul>void setValueByIndex(Position2D p,int value)<i><p>
	 * Set a value in the maze by a given position
	 * @param p - Position in the maze
	 * @param value - The value to put
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public abstract void setValueByIndex(Position2D p,int value) throws IndexOutOfBoundsException;
	
	/**
	 * <h1>Set Value By Index</h1><p>
	 * <i><ul>void setValueByIndex(int x, int y, int value)<i><p>
	 * Set a value in the maze by a given xAxis and yAxis
	 * @param x - the xAxis
	 * @param y - the yAxis
	 * @param value - The value to put
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public abstract void setValueByIndex(int x, int y, int value) throws IndexOutOfBoundsException;
	
	/**
	 * <h1>Check Position Bounds</h1><p>
	 * <i><ul>void setValueByIndex(int x, int y)<i><p>
	 * Check if the parameters are valid.
	 * @param x - the xAxis
	 * @param y - the yAxis
	 * @return true, if successful
	 */
	public abstract boolean checkPositionBounds(int x,int  y);
	
	
	/**
	 * <h1>Check Position Bounds</h1><p>
	 * <i><ul>boolean checkPositionBounds(Position2D p)<i><p>
	 * Check if the position valid are valid.
	 * @param p - the position
	 * @return true, if successful
	 */
	public abstract boolean checkPositionBounds(Position2D p);
	
	
	/**
	 * <h1>Get all possible moves</h1><p>
	 * <i><ul>ArrayList<Position2D> getPossibleMoves(Position2D pos)<i><p>
	 * Get all optional moves of given position by
	 * using {@link Position2D#MergePos(Position2D, Position2D)} method
	 * @param Position2D - position 
	 * @return ArrayList<Position2D> - list of all optional moves of the given position
	 */
	public abstract ArrayList<Position2D> getPossibleMoves(Position2D pos);

	/**
	 * <h1>Get Start</h1><p>
	 * <i><ul>Position2D getStart()<i><p>
	 * Get the start position in the maze.
	 * @return the start position
	 */
	public abstract Position2D getStart();

	/**
	 * <h1>Get End</h1><p>
	 * <i><ul>Position2D getEnd()<i><p>
	 * Get the end position in the maze.
	 * @return the end position
	 */
	public abstract Position2D getEnd();
	
}
