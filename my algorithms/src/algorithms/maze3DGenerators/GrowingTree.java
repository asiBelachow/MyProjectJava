package algorithms.maze3DGenerators;


import java.util.ArrayList;

import position.position3d.Position3D;




/**
 *<h1>GrowingTree Interface </h1><p>
 * This interface define the way to choose the next element in given ArrayList 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public interface GrowingTree {
	
	
	/**
	 * 
	 * <h1>Choose position</h1><p>
	 * <i> <ul>choosePosition(ArrayList<Position> list)<i><p>
	 * This method define the functionality of getting position from ArrayList of positions
	 * @param ArrayList<Position> 
	 * @return  Position
	 */
	public Position3D choosePosition(ArrayList<Position3D> list);

}
