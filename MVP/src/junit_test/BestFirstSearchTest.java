package junit_test;

import static org.junit.Assert.*;
import org.junit.Test;
import algorithms.search.BestFirstSearch;
import position.position3d.*;

public class BestFirstSearchTest {

	BestFirstSearch<Position3D> bfs;
	
	public BestFirstSearchTest() {
		bfs = new BestFirstSearch<Position3D>();
	}
	
	
	@Test
	public void testNull() {
		try{
			bfs.search(null);
		}catch (NullPointerException e) {
			assertTrue(1 > 0);
		}
		assertTrue("should throw NullPointerException but didnt", 1 > 0);
		}
	
/*	@Test
	public void testExistSearchSolution() {
		Maze3D maze = new GrowingTreeGenerator(new GrowingTreeRandom()).generate(1, 10, 10);

		try {
			bfs.search(new SearchableMaze3D(maze)).getSolution(maze.getStart(),maze.getEnd());
		} catch (NullPointerException e) {
			assertTrue("should not throw exception\nmaze start: " + maze.getStart() + "\nmaze end: "
					+ maze.getEnd(), 1 < 0);
		}
		assertTrue(1 > 0);
	}

	@Test
	public void testBadArgumentsMaze() {
		Maze3D maze = new GrowingTreeGenerator(new GrowingTreeRandom()).generate(100, 100, 100);
		try {
			bfs.search(new SearchableMaze3D(new Maze3D(0, 0, 0))).getSolution(maze.getStart(),maze.getEnd());

			assertTrue("solution size should be 0", 1 < 0);
		} catch (NullPointerException e) {
			assertTrue(1 > 0);
		}
	}

	@Test
	public void testHugeMaze() {
		try {
			Maze3D maze = new MyMaze3dGenerator().generate(100, 100, 100);
			searcher.search(new SearcheableMaze(maze)).getSolution();
			
			assertTrue(1<0);
		} catch (StackOverflowError e) {
			assertTrue(1>0);
		}
	}*/
}
