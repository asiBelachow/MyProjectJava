package view.gui;

import java.util.Observable;

import algorithms.search.Solution;
import maze.maze3d.*;
import position.position3d.*;
import view.AbstractObservableView;

public abstract   class ObservableCommonGUIView extends AbstractObservableView {


	public abstract void run();


	public abstract void displayMessage(String msg);

	public abstract void notifyMazeIsReady(String name);


	public abstract void update(Observable o, Object arg);

	
	public abstract void close();



	public abstract void displayMaze(Maze3D maze);

	
	public abstract void displaySolution(Solution<Position3D> solution);

	
	public abstract void notifySolutionIsReady(String name);
	
	
}
