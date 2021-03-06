package algorithms.demo;

import algorithms.maze3DGenerators.Maze3DGenerator;
import algorithms.maze3DGenerators.SimpleMaze3dGenerator;
import maze.maze3d.Maze3D;
import position.position3d.Position3D;

import java.io.IOException;

import algorithms.maze3DGenerators.GrowingTreeGenerator;
import algorithms.maze3DGenerators.GrowingTreeLast;
import algorithms.maze3DGenerators.GrowingTreeRandom;


public class Run {

	public static void main(String[] args) {
		testMazeGenerator(new SimpleMaze3dGenerator());
		testMazeGenerator(new GrowingTreeGenerator(new GrowingTreeLast()));
		testMazeGenerator(new GrowingTreeGenerator(new GrowingTreeRandom()));
		
		Demo d = new Demo();
		try {
			d.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void testMazeGenerator(Maze3DGenerator mg){
		//Prints the time it takes the algorithm to run 
		//System.out.println(mg.measureAlgorithmTime(3,3,3));
		//Generate another 3d maze
		Maze3D maze=mg.generate(3,3,3);
		//Get the maze entrance
		Position3D p=maze.getStart();
		System.out.println("\nEntrance "+p);
		System.out.println("\nThe maze\n***********************\n"+maze.toString());
		
		//Print the start position 
		//Get all the possible moves from a position 
		String[] moves=maze.getPossibleMovesAsString(p);
		// print the moves 
		System.out.printf("Possible moves: ");
		for(String move : moves)
			System.out.printf(move+" ");
		
		//Prints the maze exit position
		System.out.println("\nExit:  "+maze.getEnd());
		
		try{ 
			//Get 2d cross sections of the 3d maze 
			int[][] maze2dx=maze.getCrossSectionByX(2); 
			System.out.println("\nCross section by X:\n");
			System.out.println(maze.printCrossByAxis(maze2dx));
			int[][] maze2dy=maze.getCrossSectionByY(5); 
			System.out.println("\nCross section by Y:\n");
			System.out.println(maze.printCrossByAxis(maze2dy));
			int[][] maze2dz=maze.getCrossSectionByZ(0); 
			System.out.println("\nCross section by Z:\n");
			System.out.println(maze.printCrossByAxis(maze2dz));
			// this should throw an exception! 
			maze.getCrossSectionByX(-1); 
			
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("good!");  
		}
	}
}
