package maze;

import java.io.Serializable;


/** 
 * The Class define the common functionality of general Maze
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class AbstractMaze implements MazeInterface,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 894361212351053925L;

	/* The Constant WALL - define a wall in the maze*/
	public static final int WALL = 1;
	
	/* The Constant PASS - define a pass in the maze */
	public static final int PASS = 0;
	

	@Override
	public abstract boolean equals(Object arg);

	@Override
	public abstract String toString();

	

	
}
