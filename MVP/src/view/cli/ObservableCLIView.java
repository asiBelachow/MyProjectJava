
package view.cli;

import java.io.IOException;
import java.util.Observable;
import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;


public class ObservableCLIView extends ObservableCommonCLIView {
	
	

	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>ObservableCLIView</h1><p>
	 * <i><ul>ObservableCLIView(CLI client)<i><p>
	 * Initialize a new Observable CLI View.
	 * @param client - the class {@link CLI} that handle the user input and display
	 */
	public ObservableCLIView(CLI client) {
		super(client);
	}

	
	//-------------------------Functionality-------------------------//
	

	
	@Override
	public void run(){
		cli.start();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		if (o == cli) {
			setChanged();
			notifyObservers(arg);
		}
		
	}
	

	@Override
	public void close() {
		try {
			cli.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
		
	}

	@Override
	public void notifyMazeIsReady(String name) {
		System.out.println("maze "+ name+" ready");
		
	}


	@Override
	public void showDirPath(String str) {
		System.out.println(str);
		
	}


	@Override
	public void getCrossSection(int[][] section) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<section.length;i++){
			for( int j=0; j<section[i].length;j++){
				sb.append(section[i][j]+"   "); 
			}
			sb.append("\n");	
		}
		System.out.println(sb.toString());
		
	}


	@Override
	public void displayMaze(Maze3D maze) {
		System.out.println("Maze entrace: "+ maze.getStart());
		System.out.println("Maze exit: "+maze.getEnd());
		System.out.println(maze.toString());
		
	}
	
	@Override
	public void displaySolution(Solution<Position3D> solution) {
		System.out.println(solution.toString());
		
	}
	
	
	@Override
	public void notifySolutionIsReady(String name) {
		System.out.println("Solution for \"" + name + "\" is ready");
		
	}
	
	
}
