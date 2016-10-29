package model;



import algorithms.search.adapters.*;
import algorithms.search.BestFirstSearch;
import algorithms.search.Solution;
import maze.maze2d.Maze2D;
import position.position2d.Position2D;

public class MyModel extends AbstractModel {

	@Override
	public void solveSnake(Maze2D maze) {

		BestFirstSearch<Position2D> bfs = new BestFirstSearch<Position2D>();
		Solution<Position2D> s = bfs.search(new SearchableMaze2D<Position2D>(maze));
		setChanged();
		notifyObservers(s.getArraySolution());
		
	}

}
