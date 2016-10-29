package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeRandom;
import algorithms.search.AStar;
import algorithms.search.AirDistance;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.ManhattanDistance;
import algorithms.search.Solution;
import algorithms.search.adapters.SearchableMaze3D;
import maze.maze3d.Maze3D;
import position.position3d.Position3D;
import presenter.Properties;

/**
 *  <h1>MyModel</h1><p>
 *  This class execute clients request 
 * 
 */
public class MyModel extends AbstractModel {

	//------------------------------Data Members-------------------------//
	
	private Properties properties;
	private ConcurrentHashMap<String,Maze3D> mapMaze3D;
	private ConcurrentHashMap<String,Solution<Position3D>> mapSolution;
	private ExecutorService pool;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>MyModel</h1><p>
	 * <i>MyModel(Properties properties)<i><p>
	 * Instantiates a new MyModel.
	 * @param properties - the settings of the server
	 */
	public MyModel(Properties properties) {
		this.properties = properties;
		this.mapMaze3D = new ConcurrentHashMap<String,Maze3D>();
		this.mapSolution = new ConcurrentHashMap<String,Solution<Position3D>>();
		data = new HashMap<String, Object>();
		this.pool = Executors.newFixedThreadPool(properties.getMaxNumOfThreads());
		loadMazes();
		loadSolution();
		
	}

	public MyModel() {
	
		this.properties = new Properties();
		this.mapMaze3D = new ConcurrentHashMap<String,Maze3D>();
		this.mapSolution = new ConcurrentHashMap<String,Solution<Position3D>>();
		data = new HashMap<String, Object>();
		this.pool = Executors.newFixedThreadPool(properties.getMaxNumOfThreads());
		loadMazes();
		loadSolution();
	}

	

	public void generateMaze3D(String mazeName, int z, int x, int y){

		//Check if the maze already exists in the map .. if not

		Future<Maze3D> generatedMaze = pool.submit(new Callable<Maze3D>() {
			@Override
			public Maze3D call() throws Exception {
				//generate the maze
				Maze3D maze = (new GrowingTreeGenerator(new GrowingTreeRandom())).generate(z, x, y);
				
				return maze;
			}
		});	

		try {
			Maze3D maze = generatedMaze.get();
			if(maze!=null){
				maze.setMazeName(mazeName);
				mapMaze3D.put(mazeName, maze);
				saveMazes();
			}

		} catch (InterruptedException | ExecutionException e) {
		}
	}


	



	@Override
	public Maze3D getMaze(String name) {

		return mapMaze3D.get(name);
	}
	
	@Override
	public Solution<Position3D> getSolution(String name) {
		return mapSolution.get(name);
	}
	




	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
	
	@Override
	public void solveMaze3D(String mazeName, String alg) {

		Maze3D maze = mapMaze3D.get(mazeName);

		Future<Solution<Position3D>> mazeSolution = pool.submit(new Callable<Solution<Position3D>>() {

			@Override
			public Solution<Position3D> call() throws Exception {
				boolean flag=false;
				Solution<Position3D> solution = null;
				SearchableMaze3D<Position3D> searchableMaze = new SearchableMaze3D<Position3D>(maze);
				if(alg.matches("[Bb][Ff][Ss]")){
					solution = new BestFirstSearch<Position3D>().search(searchableMaze);
					flag =true;
				}
				else if(alg.matches("[Dd][Ff][Ss]")){
					solution = new DepthFirstSearch<Position3D>().search(searchableMaze);
					flag =true;
				}
				else if(alg.matches("[Aa][Ss][Tt][Aa][Rr][Mm][Dd]")){
					solution = new AStar<Position3D>(new ManhattanDistance()).search(searchableMaze);
					flag =true;
				}
				else if(alg.matches("[Aa][Ss][Tt][Aa][Rr][Aa][Dd]")){
					solution = new AStar<Position3D>(new AirDistance()).search(searchableMaze);
					flag =true;
				}

				if(!flag)
					return null;
				return solution;
			}

		});

		try {
			Solution<Position3D> solution = mazeSolution.get();
			mapSolution.put(mazeName, solution);
			saveSolution();
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}

	}
	
	
	
	public void saveMazes(){
		ObjectOutputStream oos = null;

		try {
			oos= new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("resources/database/mapMazes" + ".zip")));
			oos.writeObject(mapMaze3D);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public void saveSolution(){
		ObjectOutputStream oos = null;

		try {
			oos= new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("resources/database/mapSolutions" + ".zip")));
			oos.writeObject(mapSolution);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@SuppressWarnings("unchecked")
	public void loadSolution() {
		try {
			File solution = new File("resources/database/mapSolutions" + ".zip");

			if (solution.exists()) {
				ObjectInputStream in = new ObjectInputStream(new GZIPInputStream(new FileInputStream(solution))); ;
				Object o = in.readObject();

				if (o instanceof ConcurrentHashMap<?, ?>) {
					mapSolution= (ConcurrentHashMap<String,Solution<Position3D>>) o;
				}
				in.close();
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unchecked")
	public void loadMazes() {

		try {
			File maze = new File("resources/database/mapMazes" + ".zip");
			if (maze.exists()) {
				ObjectInputStream in = new ObjectInputStream(new GZIPInputStream(new FileInputStream(maze)));
				Object o = in.readObject();

				if (o instanceof ConcurrentHashMap<?, ?>) {
					mapMaze3D =  (ConcurrentHashMap<String, Maze3D>) o;
				}


				in.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


	}
	


	
	
}


