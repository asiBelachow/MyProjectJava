package maze.maze3d;

import java.util.ArrayList;

import maze.AbstractMaze;
import position.position3d.Position3D;


/** 
 * The Class define the common functionality of Maze3D
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class AbstractMaze3D extends AbstractMaze {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8789078110913704899L;

	@Override
	public abstract boolean equals(Object arg);


	@Override
	public abstract String toString();

	/**
	 * <h1>getValueByIndex</h1><p>
	 * <i><ul>abstract int getValueByIndex(int z,int x,int y)<i><p>
	 * get a position (by zAxis, xAxis and yAxis) in the maze and return it's value.
	 * @param z - the zAxis
	 * @param x - the xAxis
	 * @param y - the yAxis
	 * @return the value
	 */
	public abstract int getValueByIndex(int z,int x,int y) throws IndexOutOfBoundsException;

	/**
	 * <h1>getValueByIndex</h1><p>
	 * <i><ul>abstract int getValueByIndex(Position3D p)<i><p>
	 * get a position in the maze and return it's value.
	 * @param p - the position
	 * @return the value
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public abstract int getValueByIndex(Position3D p) throws IndexOutOfBoundsException;
	
	
	/**
	 * <h1>checkPositionBounds</h1><p>
	 * <i><ul>boolean checkPositionBounds(int z,int x,int  y)<i><p>
	 * Check if the parameters are valid.
	 * @param z - the zAxis
	 * @param x - the xAxis
	 * @param y - the yAxis
	 * @return true, if successful
	 */
	public abstract boolean checkPositionBounds(int z,int x,int  y);
	
	
	
	/**
	 * <h1>checkPositionBounds</h1><p>
	 * <i><ul>boolean checkPositionBounds(Position2D p )<i><p>
	 * Check if the position are valid.
	 * @param p - the position
	 * @return true, if successful
	 */
	public abstract boolean checkPositionBounds(Position3D p );
	
	/**
	 * <h1>Get all possible moves</h1><p>
	 * <i><ul>ArrayList<Position3D> getPossibleMoves(Position3D pos)<i><p>
	 * Get all optional moves of given position by
	 * using {@link Position3D#MergePos(Position3D, Position3D)} method
	 * @param p - position 
	 * @return ArrayList<Position2D> - list of all optional moves from the given position
	 */
	public abstract ArrayList<Position3D> getPossibleMoves(Position3D p);
	

	/**
	 * <h1>Get Start</h1><p>
	 * <i><ul>Position3D getStart()<i><p>
	 * Get the start position in the maze.
	 * @return the start position
	 */
	public abstract Position3D getStart();
	

	/**
	 * <h1>Get Start</h1><p>
	 * <i><ul>Position3D getEnd()<i><p>
	 * Get the end position in the maze.
	 * @return the start position
	 */
	public abstract Position3D getEnd();


}

