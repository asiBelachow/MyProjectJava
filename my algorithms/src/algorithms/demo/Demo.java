package algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeLast;
import algorithms.maze3DGenerators.GrowingTreeRandom;
import algorithms.search.AStar;
import algorithms.search.AirDistance;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.ManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.adapters.SearchableMaze3D;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import maze.maze3d.Maze3D;
import position.position3d.Position3D;

public class Demo {
	
	public void run() throws IOException{
		Maze3D myMaze=  new GrowingTreeGenerator(new  GrowingTreeRandom()).generate(5,5, 5);
		myMaze.setMazeName("avi");
		Maze3D myMaze1 = new GrowingTreeGenerator(new  GrowingTreeLast()).generate(5, 5, 5);
		
		
		//System.out.println(myMaze.toString());
		
		System.out.println("Start Position: "+ myMaze.getStart());
		System.out.println("Goal Position: "+ myMaze.getEnd());
		
		
		

		System.out.println("\n*************BFS Growing Random****************");
		Searcher<Position3D> bfsSearcher = new BestFirstSearch<Position3D>(); 
		Solution<Position3D> bsfSolution = bfsSearcher.search(new SearchableMaze3D<Position3D>(myMaze));
		System.out.println("The solution path is: "+ bsfSolution.toString());
		System.out.println("Number of nodes evaluated: "+ bfsSearcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************DFS Growing Random****************");
		Searcher<Position3D> dfsSearcher = new DepthFirstSearch<Position3D>(); 
		Solution<Position3D> dsfSolution = dfsSearcher.search(new SearchableMaze3D<Position3D>(myMaze));
		System.out.println("The solution path isa: "+ dsfSolution.toString());
		System.out.println("Number of nodes evaluated: "+ dfsSearcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************Astar-Manhattan Growing Random****************");
		AStar<Position3D> astarSearcher = new AStar<Position3D>(new ManhattanDistance());
		Solution<Position3D> aStarSolution = astarSearcher.search(new SearchableMaze3D<Position3D>(myMaze));
		System.out.println("The solution path is: "+ aStarSolution.toString());
		System.out.println("Number of nodes evaluated: "+ astarSearcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************Astar-AirDistance Growing Random****************");
		AStar<Position3D> astar1Searcher = new AStar<Position3D>(new AirDistance());
		Solution<Position3D> aStar1Solution = astar1Searcher.search(new SearchableMaze3D<Position3D>(myMaze));
		System.out.println("The solution path is: "+ aStar1Solution.toString());
		System.out.println("Number of nodes evaluated: "+ astar1Searcher.getNumberOfNodesEvaluated());
		
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		//System.out.println(myMaze1.toString());
		System.out.println("\n*************BFS Growing Last****************");
		Searcher<Position3D> bsf1Searcher= new BestFirstSearch<Position3D>(); 
		Solution<Position3D> bsf1Solution = bsf1Searcher.search(new SearchableMaze3D<Position3D>(myMaze1));
		System.out.println("The solution path is: "+ bsf1Solution.toString());
		System.out.println("Number of nodes evaluated: "+ bsf1Searcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************DFS Growing Last****************");
		Searcher<Position3D> dfs1Searcher= new DepthFirstSearch<Position3D>(); 
		Solution<Position3D> dfs1Solution = dfs1Searcher.search(new SearchableMaze3D<Position3D>(myMaze1));
		System.out.println("The solution path is: "+ dfs1Solution.toString());
		System.out.println("Number of nodes evaluated: "+ dfs1Searcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************Astar-Manhattan Growing Last****************");
		AStar<Position3D> astar2Searcher = new AStar<Position3D>(new ManhattanDistance());
		Solution<Position3D> aStar2Solution = astarSearcher.search(new SearchableMaze3D<Position3D>(myMaze));
		System.out.println("The solution path is: "+ aStar2Solution.toString());
		System.out.println("Number of nodes evaluated: "+ astar2Searcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************Astar-AirDistance Growing Last****************");
		AStar<Position3D> astar3Searcher = new AStar<Position3D>(new AirDistance());
		Solution<Position3D> aStar3Solution = astar3Searcher.search(new SearchableMaze3D<Position3D>(myMaze1));
		System.out.println("The solution path is: "+ aStar3Solution.toString());
		System.out.println("Number of nodes evaluated: "+ astar3Searcher.getNumberOfNodesEvaluated());
		
		
		
		
		System.out.println("\n\n********Test for import and export the Maze3D");
		System.out.println("Emport the maze3D to file");
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream("1.maz"));
		out.write(myMaze.toByteArray());
		out.flush();
		out.close();
		
		System.out.println("Import the maze3D");
		InputStream in=new MyDecompressorInputStream( new FileInputStream("1.maz")); 
		byte b[]=new byte[myMaze.toByteArray().length+10]; 
		in.read(b); 
		in.close(); 
		Maze3D loaded=new Maze3D(b);  
		System.out.printf("Check if the maze's equals: ");
		System.out.println(loaded.equals(myMaze));
	}
}
