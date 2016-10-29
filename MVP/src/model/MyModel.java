package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeRandom;
import algorithms.search.adapters.*;
import maze.maze3d.*;
import position.position3d.*;
import commands.CommandManger;
import presenter.MyPresenter;
import algorithms.search.AStar;
import algorithms.search.AirDistance;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.ManhattanDistance;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;



/**
 * <h1>class MyModel</h1><p>
 * This class execute the commands that initialized in {@link CommandManger}  </br>
 * and notify the {@link MyPresenter} about the execution </p>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public class MyModel extends AbstractModel {
	
	
	public MyModel()  {
		loadMazes();
		loadSolution();
	}
	

	//-------------------------Functionality-------------------------//
	
	@Override
	public void getDirPath(String path) {
		//Checks if the file empty
		if(path.length()==0){
			setChanged();
			notifyObservers("dir_path Please enter a directory");
			return;
			//return "dir_path Please enter a directory";
		}
			
		//Open the file
		File dir = new File(path);
		//Checks if the path is directory if not, return a message to the presenter
		if(!dir.isDirectory()){
			setChanged();
			notifyObservers("dir_path Please enter a valid directory");
			return;
		}
			//return "Please enter a valid directory";
			
		//Get list of  all files and folders in the given path and  forward to the controller
		String[] temp = dir.list();
		StringBuilder sb = new StringBuilder();
		sb.append("\nThe files in "+ path + " are: \n");
		for (String s : temp){
			sb.append(s+"\n");
		}
		setChanged();
		notifyObservers("dir_path "+sb.toString()+".");
		
	}

	@Override
	public void generateMaze3D(String mazeName, int z, int x, int y) {
		
		pool.submit(new Callable<Maze3D>() {

			@Override
			public Maze3D call() throws Exception {
				//Check if the maze already exists in the map .. if not
				if(!mapMaze3D.containsKey(mazeName)){
					//generate the maze
					Maze3D maze = (new GrowingTreeGenerator(new GrowingTreeRandom())).generate(z, x, y);
					//Save the maze to the map
					mapMaze3D.put(mazeName, maze);
					System.out.println("saved");
					saveMazes();
					setChanged();
					notifyObservers("maze_ready "+mazeName);
					return maze;
				}
				else {
					Maze3D maze = mapMaze3D.get(mazeName);
					if(((maze.getzAxis()-1)/2==z) &&( (maze.getxAxis()-1)/2==x) && ((maze.getyAxis()-1)/2==y)){
						setChanged();
						notifyObservers("message A maze with the name: \""+ mazeName+ "\" already exists please choose another name");
						return null;
						
					}else{
						setChanged();
						notifyObservers("maze_ready "+mazeName);
						return maze;
					}
				}
				
				
			}
		});		
	}

	@Override
	public int[][] CrossSectionByDimention(int index, String dimension,  String mazeName) {
		
		//Check is the maze in database
		if (mapMaze3D.containsKey(mazeName)){
			//If found get the maze
			Maze3D maze = mapMaze3D.get(mazeName);
			//if the index that the user entered invalid an IndexOutOfBoundsException will Thrown out
			try{
				//Find the dimension
				if(dimension.equals("z") || dimension.equals("Z"))
					return maze.getCrossSectionByZ(index);
				
				if(dimension.equals("x") || dimension.equals("X"))
					return maze.getCrossSectionByX(index);
				
				if(dimension.equals("y") || dimension.equals("Y")){
					return maze.getCrossSectionByY(index);
				}
			}catch (IndexOutOfBoundsException e){
				return null;
			}
		}
		//If the maze not found return a message to the CLI
		return null;
	}

	@Override
	public String saveMaze(String mazeName, String path) throws IOException  {
		
		//Check if the maze in database
		if(mapMaze3D.containsKey(mazeName)){
			//Trying to write the to a file, an Exception will Thrown out if is error while
			//trying to open the file
			try{
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(path));
				out.write(mapMaze3D.get(mazeName).toByteArray());
				out.flush();
				out.close();
			}catch (Exception e) {
				
				return "message Error while trying to save the maze, please try again";
			}
			return "The maze: \""+ mazeName+ "\" successfully saved";
			
		}else
			return "The maze: \"" + mazeName + "\" not exits";
	}

	@Override
	public Maze3D loadMaze(String file, String mazeName) throws IOException {
		Maze3D maze;
		//boolean flag = false;
		//Trying to open a file, IF the file not found FileNotFoundException will Thrown out
		try {
			File f = new File(file);
			@SuppressWarnings("resource")
			InputStream in=new MyDecompressorInputStream( new FileInputStream(f));
			byte b[] = new byte[(int) f.length()];
			in.read(b);
			maze = new Maze3D(b);//Load the maze
			mapMaze3D.put(mazeName, maze);//Saving the maze to the database
		} catch (FileNotFoundException e) {
			System.out.println("file not found ");
			return null;
		}
		
		return maze;
		
	}

	@Override
	public void solveMaze(String mazeName, String alg) {
		
		pool.submit(new Callable<Solution<Position3D>>() {

			@Override
			public Solution<Position3D> call() throws Exception {
				boolean flag=false;
				Solution<Position3D> solution = null;
				
				//Check if the solution already exits
				if(!mapSolution.contains(mazeName)){
					//Solve the maze
					Maze3D maze = mapMaze3D.get(mazeName);
					if(alg.matches("[Bb][Ff][Ss]")){
						solution = new BestFirstSearch<Position3D>().search(new SearchableMaze3D<>(maze));
						flag =true;
					}
					else if(alg.matches("[Dd][Ff][Ss]")){
						solution = new DepthFirstSearch<Position3D>().search(new SearchableMaze3D<>(maze));
						flag =true;
					}
					else if(alg.matches("[Aa][Ss][Tt][Aa][Rr][Mm][Dd]")){
						solution = new AStar<Position3D>(new ManhattanDistance()).search(new SearchableMaze3D<>(maze));
						flag =true;
					}
					else if(alg.matches("[Aa][Ss][Tt][Aa][Rr][Aa][Dd]")){
						solution = new AStar<Position3D>(new AirDistance()).search(new SearchableMaze3D<>(maze));
						flag =true;
					}

					if(flag==false)
						return null;
					mapSolution.put(mazeName, solution);
					saveSolution();
					setChanged();
					notifyObservers("solution_ready "+ mazeName);
					return solution;
				}
				//if the solution already exits return it
				setChanged();
				notifyObservers("solution_ready "+ mazeName);
				return mapSolution.get(mazeName);
			}
		});
	}


	@Override
	public Maze3D displayMaze(String name) {
		
		return mapMaze3D.get(name);
	}
	
	
	@Override
	public Solution<Position3D> displaySolution(String mazeName) {
		Solution<Position3D> s = mapSolution.get(mazeName);
		if(s !=null)
			return s;
		return null;
	}
	
	@Override
	public String displayListOfAllMaze() {
		//Check if there is maze in database
		if(mapMaze3D.isEmpty())
			return "The database empty";
		else {
			//Get list of all maze's name in database
			StringBuilder sb = new StringBuilder();
			Iterator<String> iter = mapMaze3D.keySet().iterator();
			int i=1;
			sb.append("\nList of all maze:\n");
			while (iter.hasNext())
				sb.append(i+") "+iter.next()+"\n");
			return sb.toString();
		}
	}
	
	public String displayMenu(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n*********************************************************************\n");
		sb.append("*                               CLI Menu                            *\n");
		sb.append("*********************************************************************\n");
		sb.append("1) To view file in directory enter: dir <path>\n");
		sb.append("2) To generate new Maze3D enter: generate_maze <name> <other params>\n");
		sb.append("3) To display a Maze3d enter: display <name>\n");
		sb.append("4) To dispaly cross section of the Maze3D enter: display_cross_section <index{xz,x,y} <name>\n");
		sb.append("5) To display a Maze3d enter: display <name>\n");
		sb.append("6) To save a Maze3D enter: save_maze <name> <file name>\n");
		sb.append("7) To load saved Maze3D enter: load_maze <file name> <name>\n");
		sb.append("8) To solve a Maze3D enter: solve <name> <algorithm(BFS,DFS,AStarMD,AstartAD)>\n");
		sb.append("9) To display the solution path of the maze enter: display_solution <name>\n");
		sb.append("10) To display the menu enter: menu\n");
		sb.append("11) To exit enter: exit\n");
		
		return sb.toString();
	}

	public void exit(){

		//presenter.setSolution("CLI closing...");
		pool.shutdown();
		try {
			pool.awaitTermination(10,TimeUnit.SECONDS );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
