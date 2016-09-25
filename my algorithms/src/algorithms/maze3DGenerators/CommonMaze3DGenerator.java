package algorithms.maze3DGenerators;

import java.util.Random;


/**
 * <h1>class CommonMaze3DGenerator</h1><p>
 * This class defines the common functionality of algorithms to build a 3d maze 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class CommonMaze3DGenerator implements Maze3DGenerator {
	
	
	//------------------------------Data Members-------------------------//
	
	protected Maze3D myMaze;
	
	protected Random r = new Random();
	
	

	/* (non-Javadoc)
	 * @see algorithms.maze3DGenerators.Maze3DGenerator @link #generate(int, int, int)
	 */
	@Override
	public abstract Maze3D generate(int zAxis, int xAxis, int yAxis);
		
	

	/* (non-Javadoc)
	 * @see algorithms.maze3DGenerators.Maze3DGenerator @link #measureAlgorithmTime(int, int, int)
	 */
	@Override
	public String measureAlgorithmTime(int zAxis, int xAxis, int yAxis) {
	
		double start = System.currentTimeMillis();
		generate(zAxis, xAxis, yAxis);
		double finish = System.currentTimeMillis();
		String delims = "[.]";
		String[] tokens = this.getClass().toString().split(delims);
		return tokens[tokens.length-1]+" Running time: "+ Double.toString((finish - start) * (Math.pow(10, -3)))+"\n";
	}

}
