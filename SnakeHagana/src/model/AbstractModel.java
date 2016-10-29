package model;

import java.util.Observable;
import maze.maze2d.Maze2D;

public abstract class AbstractModel extends Observable implements Model  {
	

	@Override
	public abstract void solveSnake(Maze2D maze);


}
