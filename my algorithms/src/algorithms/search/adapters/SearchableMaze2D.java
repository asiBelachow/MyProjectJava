package algorithms.search.adapters;

import java.util.ArrayList;

import algorithms.search.CommonSearchable;
import algorithms.search.State;
import maze.maze2d.Maze2D;
import position.position2d.Position2D;


public class SearchableMaze2D<T> extends CommonSearchable<Position2D> {

	private Maze2D mayMaze;
	
	
	//------------------------------Constructors-------------------------//
	
	
	/**
	 * <h1>SearchableMaze3D</h1><p>
	 * <i><ul>SearchableMaze3D(Maze3D myMaze)<i><p>
	 * Initialization a Searchable Maze3D
	 * @param - aMaze3D
	 */
	public SearchableMaze2D(Maze2D myMaze) {
		setMayMaze(myMaze);
	}
	
	public SearchableMaze2D(Maze2D myMaze,double cost) {
		super(cost);
		setMayMaze(myMaze);
	}
	
	public Maze2D getMayMaze() {
		return mayMaze;
	}

	public void setMayMaze(Maze2D mayMaze) {
		this.mayMaze = mayMaze;
	}

	
	

	//-------------------------------Functionality------------------------------//

	@Override
	public State<Position2D> getInitialState() {
		State<Position2D> start = new State<Position2D>(getMayMaze().getStart());
		start.setCost(0);
		start.setCameFrom(null);
		return start;
	}
	

	@Override
	public State<Position2D> getGoalState() {
		State<Position2D> end = new State<Position2D>(getMayMaze().getEnd());
		return end;
	}

	@Override
	public ArrayList<State<Position2D>> getAllPossibleStates(State<Position2D> s) {
		ArrayList<Position2D> pMoves = getMayMaze().getPossibleMoves(s.getState()); 
		
		ArrayList<State<Position2D>> stateList = new ArrayList<State<Position2D>>();

		for (int i=0;i < pMoves.size(); i++){
			stateList.add(new State<Position2D>(pMoves.get(i)));
			stateList.get(i).setCameFrom(s);
			stateList.get(i).setCost(getCostValue());
		}
		return stateList;
	}

	@Override
	public ArrayList<Integer> calcAirdis(State<Position2D> currentState) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
