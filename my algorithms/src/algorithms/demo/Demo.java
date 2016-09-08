package algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeLast;
import algorithms.maze3DGenerators.GrowingTreeRandom;
import algorithms.maze3DGenerators.Maze3D;
import algorithms.maze3DGenerators.Position;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Demo {
	
	public void run() throws IOException{
		Maze3D myMaze=  new GrowingTreeGenerator(new  GrowingTreeRandom()).generate(10,10, 10);
		Maze3D myMaze1 = new GrowingTreeGenerator(new  GrowingTreeLast()).generate(5, 5, 5);
		
		
		System.out.println(myMaze.toString());
		
		System.out.println("Start Position: "+ myMaze.getStart());
		System.out.println("Goal Position: "+ myMaze.getEnd());
		
		


		System.out.println("\n*************BFS Growing Random****************");
		Searcher<Position> bfsSearcher = new BestFirstSearch<Position>(); 
		Solution<Position> bsfSolution = bfsSearcher.search(new SearchableMaze3D<>(myMaze));
		System.out.println("The solution path is: "+ bsfSolution.toString());
		System.out.println("Number of nodes evaluated: "+ bfsSearcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************DFS Growing Random****************");
		Searcher<Position> dfsSearcher = new DepthFirstSearch<Position>(); 
		Solution<Position> dsfSolution = dfsSearcher.search(new SearchableMaze3D<>(myMaze));
		System.out.println("The solution path isa: "+ dsfSolution.toString());
		System.out.println("Number of nodes evaluated: "+ dfsSearcher.getNumberOfNodesEvaluated());
		System.out.println("-------------------------------------------------------------------------------------");
		
		//System.out.println(myMaze1.toString());
		System.out.println("\n*************BFS Growing Last****************");
		Searcher<Position> bsf1Searcher= new BestFirstSearch<Position>(); 
		Solution<Position> bsf1Solution = bsf1Searcher.search(new SearchableMaze3D<>(myMaze1));
		System.out.println("The solution path is: "+ bsf1Solution.toString());
		System.out.println("Number of nodes evaluated: "+ bsf1Searcher.getNumberOfNodesEvaluated());
		
		System.out.println("\n*************DFS Growing Last****************");
		Searcher<Position> dfs1Searcher= new DepthFirstSearch<Position>(); 
		Solution<Position> dfs1Solution = dfs1Searcher.search(new SearchableMaze3D<>(myMaze1));
		System.out.println("The solution path is: "+ dfs1Solution.toString());
		System.out.println("Number of nodes evaluated: "+ dfs1Searcher.getNumberOfNodesEvaluated());
		
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
