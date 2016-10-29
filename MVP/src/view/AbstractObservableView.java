package view;

import java.util.Observable;
import java.util.Observer;
import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;


/**
 * <h1>class AbstractObservableView</h1><p>
 * This class defines the common functionality of the view part<br>
 *  of the Graphic User Interface and Command Line Interface in our MVP architecture
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractObservableView extends Observable implements View, Observer {
	/**
	 *<h1>MyCommonModel</h1><p>
	 * <i><ul>MyCommonModel(Controller cont)<i><p>
	 * Initialize a new abstract observable view.
	 */
	
	public AbstractObservableView() {
	

	}
	
	//-------------------------Functionality-------------------------//

	
	public abstract void close();
	
	
	public abstract void getCrossSection(int[][] section);
	
	
	
	public abstract void displayMaze(Maze3D maze);
	
	
	public abstract void displaySolution(Solution<Position3D> solution);
	
	public abstract void notifySolutionIsReady(String name);
	


	
	
	
	

}
