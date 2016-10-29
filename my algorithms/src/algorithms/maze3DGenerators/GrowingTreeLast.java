package algorithms.maze3DGenerators;


import java.util.ArrayList;

import position.position3d.Position3D;


/**
 * The Class GrowingTreeLast.
 * 
 * return  the last element in given ArrayList
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class GrowingTreeLast implements GrowingTree {


	/* (non-Javadoc)
	 * @see algorithms.maze3DGenerators.GrowingTree#choosePosition(java.util.ArrayList)
	 */
	@Override
	public Position3D choosePosition(ArrayList<Position3D> list) {
		
		return list.get(list.size()-1);
	}

}
