package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import algorithms.demo.SearchableMaze3D;
import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeRandom;
import algorithms.maze3DGenerators.Maze3D;
import algorithms.maze3DGenerators.Position;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Solution;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel extends MyCommonModel {
	
	
	//------------------------------Constructors-------------------------//
	
	public MyModel(Controller cont) {
		super(cont);
	}

	//-------------------------Functionality-------------------------//
	
	@Override
	public void dirPath(String path) {
		//Checks if the file empty
		if(path.length()==0){
			controller.setSolution("The directory is empty");
			return;
		}
		//Open the file
		File dir = new File(path);
		//Checks if the path is directory if not, return a message to the controller
		if(!dir.isDirectory()){
			
			controller.setSolution("The path is not a directory");
			return;
		}
		//Get list of  all files and folders in the given path and  forward to the controller
		String[] temp = dir.list();
		StringBuilder sb = new StringBuilder();
		sb.append("\nThe files in "+ path + " are: \n");
		for (String s : temp){
			sb.append(s+"\n");
		}
		controller.setSolution(sb.toString());
		
	}

	@Override
	public void generateMaze3D(String mazeName, int z, int x, int y) {

		
		 Runnable r = new Runnable() {
			 
			public void run() {
				//Checks if maze already exists
				if ( !mapMaze3D.containsKey(mazeName)){
					//Generate new maze
					Maze3D maze = (new GrowingTreeGenerator(new GrowingTreeRandom())).generate(z, x, y);
					mapMaze3D.put(mazeName, maze);
					controller.setSolution("\nThe maze \""+ mazeName + "\" is ready");
					return;
				}
				controller.setSolution("The maze \""+ mazeName + "\" already exits");
			}
		};
		
		execute(r);	
	}

	@Override
	public void CrossSectionByDimention(int index, String dimension,  String mazeName) {
		
		//Check is the maze in database
		if (mapMaze3D.containsKey(mazeName)){
			//If found get the maze
			Maze3D maze = mapMaze3D.get(mazeName);
			//if the index that the user entered invalid an IndexOutOfBoundsException will Thrown out
			try{
				//Find the dimension
				if(dimension.equals("z")){
					controller.setSolution(maze.printCrossByAxis(maze.getCrossSectionByX(index)));
					return;
				}
				if(dimension.equals("x")){
					controller.setSolution(maze.printCrossByAxis(maze.getCrossSectionByY(index)));
					return;
				}
				if(dimension.equals("y")){
					controller.setSolution(maze.printCrossByAxis(maze.getCrossSectionByZ(index)));
					return;
				}
			}catch (IndexOutOfBoundsException e){
				controller.setSolution(e.toString().substring(37));
				return;
			}
		}
		//If the maze not found return a message to the CLI
		controller.setSolution("Maze: \"" + mazeName + "\" not found");
		
	}

	@Override
	public void saveMaze(String mazeName, String path) throws IOException  {
		
		//Check if the maze in database
		if(mapMaze3D.containsKey(mazeName)){
			//Trying to write the to a file, an Exception will Thrown out if is error while
			//trying to open the file
			try{
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(path+".maz"));
				out.write(mapMaze3D.get(mazeName).toByteArray());
				out.flush();
				out.close();
			}catch (Exception e) {
				controller.setSolution("Error while trying to save the maze, please try again");
			}
			//Send message to the CLI that the save was successful
			controller.setSolution("The maze: \""+ mazeName+ "\" successfully saved");
			return;
		}

		//If the maze not found return a message to the CLI
		controller.setSolution("The maze: \"" + mazeName + "\" not exits");

	}

	@Override
	public void loadMaze(String file, String mazeName) throws IOException {
		
		boolean flag = false;
		//Trying to open a file, IF the file not found FileNotFoundException will Thrown out
		try {
			File f = new File(file+".maz");
			@SuppressWarnings("resource")
			InputStream in=new MyDecompressorInputStream( new FileInputStream(f));
			byte b[] = new byte[(int) f.length()];
			in.read(b);
			Maze3D maze = new Maze3D(b);//Load the maze
			mapMaze3D.put(mazeName, maze);//Saving the maze to the database
			
		} catch (FileNotFoundException e) {
			flag=true;
			controller.setSolution("The file: \""+ file + "\" not found");
		}
		
		if(flag == false){
			controller.setSolution("Maze: \""+mazeName+ "\" loaded sucssefuly");
		}
	}

	@Override
	public void solveMaze(String mazeName, String alg) {
		//Create new anonymous runnable to solve the given maze
		Runnable r = new Runnable() {
			public void run() {
				//Check if the maze in database, if exists
				if ( mapMaze3D.containsKey(mazeName)){

					Solution<Position> sol = null;
					//Checks with which algorithm to solve the maze 
					if(alg.equals("BFS")){
						sol = new BestFirstSearch<Position>().search(new SearchableMaze3D<Position>(mapMaze3D.get(mazeName)));
						mapSolution.put(mazeName, sol);
						controller.setSolution("\nThe solution for: \"" + mazeName + "\" is ready");
						return;
					}
					if(alg.equals("DFS")){
						sol = new DepthFirstSearch<Position>().search(new SearchableMaze3D<Position>(mapMaze3D.get(mazeName)));
						controller.setSolution("The solution for: \"" + mazeName + "\" is is ready ");
						mapSolution.put(mazeName, sol);
						return;
					}
				}
				//If the maze not exists update the CLI
				controller.setSolution("The maze \""+ mazeName + "\" not found");
			}
		};
		
		//Insert the runnable to the pool
		execute(r);

	}


	@Override
	public void displayMaze(String name) {
		
		if(mapMaze3D.containsKey(name)){
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			sb.append("Enterance: " + mapMaze3D.get(name).getStart().toString());
			sb.append("\n");
			sb.append("Exit: " + mapMaze3D.get(name).getEnd().toString());
			sb.append("\n");
			sb.append(mapMaze3D.get(name).toString());
			controller.setSolution(sb.toString());
			return;
		}
	
		controller.setSolution(("Maze: \""+name+ "\" not found"));	
	}
	
	
	@Override
	public void displaySolution(String mazeName) {
		//Check if the maze in database, if exists get the maze
		if(mapSolution.containsKey(mazeName)){
			controller.setSolution(mapSolution.get(mazeName).toString());
			return;
		}
		//If not exits, return message to hte CLI
		controller.setSolution("The maze: \""+ mazeName+"\" not found");
	}
	
	@Override
	public void displayListOfAllMaze() {
		//Check if there is maze in database
		if(mapMaze3D.isEmpty()){
			controller.setSolution("The database empty");
			return;
		}
		//Get list of all maze's name in database
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = mapMaze3D.keySet().iterator();
		int i=1;
		sb.append("\nList of all maze:\n");
		while (iter.hasNext()){
			sb.append(i+") "+iter.next()+"\n");
		}
		
		controller.setSolution(sb.toString()+"\n");
		
	}
	
	public void displayMenu(){
		
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
		sb.append("8) To solve a Maze3D enter: solve <name> <algorithm(BFS,DFS)>\n");
		sb.append("9) To display the solution path of the maze enter: display_solution <name>\n");
		sb.append("10) To display the menu enter: menu\n");
		sb.append("11) To exit enter: exit\n");
		
		controller.setSolution(sb.toString());
	
	}

	public void close(){
		controller.setSolution("CLI closing...");
		pool.shutdown();
		controller.setSolution("CLI closed...");
	}
	


}
