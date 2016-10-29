package view.cli;

import java.util.Observable;

import algorithms.search.Solution;
import maze.maze3d.*;
import position.position3d.*;
import view.AbstractObservableView;


/**
 * <h1>class ObservableCommonCLIView</h1><p>
 * This class defines the common functionality of the view part<br>
 *  of the Command Line Interface in our MVP architecture
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class  ObservableCommonCLIView extends AbstractObservableView{

	
	/** The cli. */
	protected CLI cli;
	
	
	/**
	 * <h1>ObservableCommonCLIView</h1><p>
	 * <i><ul>ObservableCommonCLIView(CLI client)<i><p>
	 * Initialize a new Observable CommonCLI View.
	 * @param client - the class {@link CLI} that handle the user input and display
	 */
	public ObservableCommonCLIView(CLI client) {
		setCli(client);
		
	}

	
	/**
	 * <h1>Get Cli</h1><p>
	 * <i>CLI getCli()<i><p>
	 * get the data member cli.
	 * @return the data member cli {@link CLI}
	 */
	public CLI getCli() {
		return cli;
	}

	/**
	 * <h1>Set Cli</h1><p>
	 * <i>CLI setCli()<i><p>
	 * set the data member cli.
	 * @param cli - {@link CLI}
	 */
	public void setCli(CLI cli) {
		this.cli = cli;
	}
	
	
	@Override
	public abstract void run();

	@Override
	public abstract void displayMessage(String msg);

	@Override
	public abstract void notifyMazeIsReady(String name);


	@Override
	public abstract void update(Observable o, Object arg);

	@Override
	public abstract void close();

	@Override
	public abstract void getCrossSection(int[][] section);

	
	/**
	 *<h1>Show Dir Path</h1><p>
	 * <i><ul>void showDirPath(String str)<i><p>
	 * Display all files in directory
	 * @param str - the directory
 	 */
	public abstract void showDirPath(String str);

	@Override
	public abstract void displayMaze(Maze3D maze);

	@Override
	public void displaySolution(Solution<Position3D> solution) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public abstract void notifySolutionIsReady(String name);

}
