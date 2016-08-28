package algorithms.search;

import java.util.ArrayList;

import algorithms.maze3DGenerators.Maze3D;



/**
 * The Class CommonSearchable.
 *
 * @param <T> the generic type
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public abstract class CommonSearchable<T> implements Searchable<T> {

	
	protected Maze3D myMaze;
	protected double costValue;
	
	//------------------------------Constructors-------------------------//
	
	public CommonSearchable(Maze3D myMaze) {
		this.myMaze = myMaze;
		setCostValue(1);
		
	}
	
	public CommonSearchable(Maze3D myMaze, double cost) {
		setMyMaze(myMaze);
		setCostValue(cost);
		
	}
	
	//-----------------------------setters and getters-------------------//
	
	public Maze3D getMyMaze() {
		return myMaze;
	}

	public void setMyMaze(Maze3D myMaze) {
		this.myMaze = myMaze;
	}

	public void setCostValue(double costValue) {
		this.costValue = costValue;
	}
	
	
	@Override
	public  double getCostValue(){
		return costValue;
	}
	
	//-------------------------------Functionality------------------------------//
	
	@Override
	public abstract State<T> getInitialState();


	@Override
	public abstract State<T> getGoalState();


	@Override
	public abstract ArrayList<State<T>> getAllPossibleStates(State<T> s);
	


	
}
