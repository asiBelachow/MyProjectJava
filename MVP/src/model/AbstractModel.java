package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import maze.maze3d.*;
import position.position3d.*;
import algorithms.search.Solution;



/**
 * <h1>class AbstractModel</h1><p>
 * This class defines the common functionality of the model in MVP architectural pattern</br>
 * Manages the data, logic and rules of the MVP architectural pattern </p>
 * <b>Data structure :</b>
 * <li><b>mapMaze3D</b> - hold the {@link Maze3D} with name</br>
 * <li><b>mapSolution</b> - hold the {@link Solution} of the Maze3D with name</br></br>
 * <b>Data member :</b>
 * <li><b>{@link Controller}</b>
 * <li><b>ExecutorService</b> - manage the threads
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractModel extends Observable implements Model {
	
	//------------------------------Data Members-------------------------//
	
	protected ExecutorService pool;
	
	protected ConcurrentHashMap<String,Maze3D> mapMaze3D;
	
	protected ConcurrentHashMap<String,Solution<Position3D>> mapSolution;
	
	protected Solution<Position3D> hint;
	
	HashMap<String, Object> data;
	
	
	//------------------------------Constructors-------------------------//
	


	/**
	 *<h1>MyCommonModel</h1><p>
	 * <i><ul>MyCommonModel(Controller cont)<i><p>
	 * Initialize a new Model
	 */
	public AbstractModel() {
		mapMaze3D = new ConcurrentHashMap<String,Maze3D>();
		mapSolution = new ConcurrentHashMap<String,Solution<Position3D>>();
		this.pool = Executors.newCachedThreadPool();
		data = new HashMap<String, Object>();

	}
	
	void execute(Runnable r){
		pool.execute(r);
	}
	
	
	//-----------------------------setters and getters-------------------//




	
	//-------------------------Functionality-------------------------//
	
	/* (non-Javadoc)
	 * @see model.Model#dirPath(java.lang.String)
	 */
	@Override
	public abstract void getDirPath(String path);


	/* (non-Javadoc)
	 * @see model.Model#generateMaze3D(java.lang.String, int, int, int)
	 */
	@Override
	public abstract void generateMaze3D(String mazeName, int z, int x, int y);



	/* (non-Javadoc)
	 * @see model.Model#CrossSectionByDimention(int, java.lang.String, java.lang.String)
	 */
	@Override
	public abstract int[][] CrossSectionByDimention(int index, String crossSection,  String mazeName);



	/* (non-Javadoc)
	 * @see model.Model#saveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public abstract String saveMaze(String mazeName, String path) throws IOException;
	

	/* (non-Javadoc)
	 * @see model.Model#loadMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public abstract Maze3D loadMaze(String file, String mazeName) throws IOException;



	/* (non-Javadoc)
	 * @see model.Model#solveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public abstract void solveMaze(String mazeName, String alg);
	
	/* (non-Javadoc)
	 * @see model.Model#displayMaze(java.lang.String)
	 */
	@Override
	public abstract Maze3D displayMaze(String name);
	

	/* (non-Javadoc)
	 * @see model.Model#displaySolution(java.lang.String)
	 */
	@Override
	public abstract Solution<Position3D> displaySolution(String mazeName);



	/* (non-Javadoc)
	 * @see model.Model#displayListOfAllMaze()
	 */
	@Override
	public abstract String displayListOfAllMaze();
	
	/* (non-Javadoc)
	 * @see model.Model#displayMenu()
	 */
	@Override
	public abstract String displayMenu();
	
	
	
	public abstract void exit();


	/**
	 * Puts the data in a hashmap and notifies the command
	 * @param command command to notify
	 * @param data data to save for when the client asks using getCommandData
	 */
	protected void setCommandAndNotify(String command, Object args)
	{
		if (data!=null)
			data.put(command, args);
		setChanged();
		notifyObservers(command);
	}
	
	
		
	
	

	

}
