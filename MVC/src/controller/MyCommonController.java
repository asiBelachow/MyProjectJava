package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import allCommands.Close;
import allCommands.Command;
import allCommands.DirPath;
import allCommands.DisplayCrossSectionByDimension;
import allCommands.DisplayMaze;
import allCommands.DisplayMenu;
import allCommands.DisplaySolution;
import allCommands.DisplyListOfAllMaze;
import allCommands.GenerateMaze3D;
import allCommands.LoadMaze;
import allCommands.SaveMaze;
import allCommands.SolveMaze;
import model.Model;
import view.View;



/**
 * <h1>class MyCommonController</h1><p>
 * This class defines the common functionality  in order to</br>
 *  connect between the {@link Model} and the {@link View} </p>
 *   <b>Data members :</br>
 *   <li>{@link View}</br>
 *   <li>{@link ModelD}</br>
 *   <li>{@link ExecutorService}</p>
 *   <b>Data structure :</b></p>
 *   <li>HashMap<String, Command> commands</br>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class MyCommonController implements Controller {
	
	//------------------------------Data Members-------------------------//
	
	protected View v;
	
	protected Model m;
	
	protected HashMap<String, Command> commands;
	
	protected ExecutorService threadPool;
	
	//-------------------------Constructors-------------------------//
	
	/**
	 *<h1>My Common Controller</h1><p>
	 * <i><ul>MyCommonController()<i><p>
	 * Initialize a new Controller
	 */
	public MyCommonController() {
		this.threadPool = Executors.newCachedThreadPool();
	}
	
	//-------------------------Functionality-------------------------//
	
	@Override
	public void setModel(Model m) {
		this.m = m;
	}
	
	@Override
	public void setView(View v) {
		this.v = v;
	}
	

	/**
	 * <h1>Sets the commands</h1><p>
	 * <i><ul>HashMap<String, Command> setCommands()<i><p>
	 * Set the HashMap with {@link Command} and key
	 * @return HashMap 
	 */
	public HashMap<String, Command> setCommands(){
		
		commands = new HashMap<String, Command>();

		commands.put("dir [^\n]+", new DirPath(m));
		commands.put("generate_maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}", new GenerateMaze3D(m));
		commands.put("display [A-Za-z0-9]+", new DisplayMaze(m));
		commands.put("display_cross_section [0-9]{1,2} [A-Za-z0-9]+ [A-Za-z0-9]+", new DisplayCrossSectionByDimension(m));
		commands.put("save_maze [A-Za-z0-9]+ [^\n]+", new SaveMaze(m));
		commands.put("load_maze [^\n]+ [A-Za-z0-9]+", new LoadMaze(m));
		commands.put("solve [A-Za-z0-9]+ [A-Za-z0-9]+", new SolveMaze(m));
		commands.put("display_solution [A-Za-z0-9]+", new DisplaySolution(m));
		commands.put("display_menu", new DisplayMaze(m));
		commands.put("list_maze", new DisplyListOfAllMaze(m));
		commands.put("menu", new DisplayMenu(m));
		commands.put("exit", new Close(m));
		return commands;
	}
	
	/**
	 * <h1>Gets the commands</h1><p>
	 * <i><ul>HashMap<String, Command> getCommands()<i><p>
	 * Get the HashMap with {@link Command} and key
	 * @return HashMap 
	 */
	public HashMap<String, Command> getCommands(){
		return commands;
	}

	/* (non-Javadoc)
	 * @see controller.Controller#forwardCommand(java.lang.String, java.lang.String[])
	 */
	@Override
	public abstract void forwardCommand(String command, String[] param) throws IOException;

	
	/* (non-Javadoc)
	 * @see controller.Controller#setSolution(java.lang.String)
	 */
	@Override
	public abstract void setSolution(String solution);
	

}
