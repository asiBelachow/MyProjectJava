
package view.cli;

import java.io.IOException;
import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;
import commands.Command;


/**
 * <h1>ObservableCLIView</h1><p>
 * A type of view in the MVP architecture using the command line
 * (BufferedReader/PrintWriter)
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public class ObservableCLIView extends ObservableCommonCLIView {
	
	//------------------------------Data Members-------------------------//
	
	
	private static final String EXIT_COMMAND = "exit";

	
	//-------------------------Functionality-------------------------//
	
	
	@Override
	public void start() {
		run();
	}
	

	@Override
	public void run(){
		String input = null;
		try {

			System.out.println("************************************************************");
			System.out.println("*                   Command Line Interface                 *");
			System.out.println("************************************************************");
			System.out.println("*To view commands enter menu");
			System.out.printf("Please enter command: ");
			System.out.flush();
			while(!(input=cli.getIn().readLine()).equals(EXIT_COMMAND)){
				Command cmd = cli.getCommandByInput(input);
				if(cmd!=null)
					setCommandAndNotify(cmd,input.split(" "));
				else
					System.out.println("You entered unrecognized command " + input);

				System.out.println("\nPlease enter command: ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		setCommandAndNotify(cli.getCommandByInput(input),null);
		close();
	}

	

	@Override
	public void close() {
		writeToConsole("************************************************************");
		writeToConsole("*            Command Line Interface Closed                 *");
		writeToConsole("************************************************************");
		try {
			cli.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void displayMessage(String msg) {
		//System.out.println(msg);
	}

	@Override
	public void notifyMazeIsReady(String name) {
		System.out.println("maze "+ name+" ready");
		
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
	@Override
	public void writeToConsole(String msg) {
		System.out.println(msg);
		
	}
	
	@Override
	public void resetGameEvetHandler() {
		//Done on gui side
		
	}
	
	@Override
	public void connectToServerEventHandler() {
		//Done on gui side
		
	}
	
	@Override
	public void disconnectFromServerEventHandler() {
		//Done on gui side
		
	}
	
}
