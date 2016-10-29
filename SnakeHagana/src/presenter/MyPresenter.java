package presenter;

import java.util.ArrayList;
import java.util.Observable;

import maze.maze2d.Maze2D;
import model.Model;
import position.position2d.Position2D;
import view.View;


public class MyPresenter  extends AbstractPresenter{

	public MyPresenter(Model model, View view) {
		super(model, view);
	
	}

	
	@Override
	public void update(Observable o, Object arg) {
		
		if( o==view){
			Maze2D maze = (Maze2D)arg;
			model.solveSnake(maze);
		}
		
		if( o==model){
			@SuppressWarnings("unchecked")
			ArrayList<Position2D> sol = (ArrayList<Position2D>)arg;
			view.displaySolution(sol);
			
			
		}
	}
}
