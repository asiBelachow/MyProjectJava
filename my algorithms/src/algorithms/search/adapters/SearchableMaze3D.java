package algorithms.search.adapters;

import java.util.ArrayList;

import algorithms.search.CommonSearchable;
import algorithms.search.State;
import maze.maze3d.Maze3D;
import position.position3d.Position3D;



/**
 * <h1>State<T></h1><p>
 * This class extends the CommonSearchable class and its define a searchable Maze3D
 * @param <T> the generic type
 * @author Asi Belachow
 * @version 1.0
 * @param <T>
 * @since 2016-28-08

 */
public class SearchableMaze3D<T> extends CommonSearchable<Position3D> {
	
	
	private Maze3D mayMaze;
	
	
	//------------------------------Constructors-------------------------//
	
	
	/**
	 * <h1>SearchableMaze3D</h1><p>
	 * <i><ul>SearchableMaze3D(Maze3D myMaze)<i><p>
	 * Initialization a Searchable Maze3D
	 * @param - aMaze3D
	 */
	public SearchableMaze3D(Maze3D myMaze) {
		setMayMaze(myMaze);
	}
	
	public SearchableMaze3D(Maze3D myMaze,double cost) {
		super(cost);
		setMayMaze(myMaze);
	}
	
	public Maze3D getMayMaze() {
		return mayMaze;
	}

	public void setMayMaze(Maze3D mayMaze) {
		this.mayMaze = mayMaze;
	}

	
	

	//-------------------------------Functionality------------------------------//

	@Override
	public State<Position3D> getInitialState() {
		State<Position3D> start = new State<Position3D>(getMayMaze().getStart());
		start.setCost(0);
		start.setCameFrom(null);
		return start;
	}
	

	@Override
	public State<Position3D> getGoalState() {
		State<Position3D> end = new State<Position3D>(getMayMaze().getEnd());
		return end;
	}

	@Override
	public ArrayList<State<Position3D>> getAllPossibleStates(State<Position3D> s) {
		ArrayList<Position3D> pMoves = getMayMaze().getPossibleMoves(s.getState()); 
		
		ArrayList<State<Position3D>> stateList = new ArrayList<State<Position3D>>();

		for (int i=0;i < pMoves.size(); i++){
			stateList.add(new State<Position3D>(pMoves.get(i)));
			stateList.get(i).setCameFrom(s);
			stateList.get(i).setCost(getCostValue());
		}
		return stateList;
	}



	
	public ArrayList<Integer> calcAirdis(State<Position3D> s){
		ArrayList<Integer> air =  new ArrayList<>();
		
		State<Position3D> pos = new State<Position3D>(s.getState());
		
		air.add(Math.abs(mayMaze.getEnd().getZ() - pos.getState().getZ()));
		air.add(Math.abs(mayMaze.getEnd().getY() - pos.getState().getY()));
		air.add(Math.abs(mayMaze.getEnd().getX() - pos.getState().getX()));
		
		return air;	
	}

	

	




	
}
