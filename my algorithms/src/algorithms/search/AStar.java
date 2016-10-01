package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import position.position3d.Position3D;

/**
 * The Class Astar_Algorithem.
 *
 * @param <T> the generic type
 */
public class AStar<T> extends CommonSearcher<T> {

	/** The Heuristic. */
	private Heuristic heuristic;
	protected PriorityQueue<State<T>> openList;
	/**
	 * Instantiates the specific heuristic for astar.
	 * Contractor
	 * @param Heuristic
	 */
	public AStar(Heuristic H) {
		this.heuristic = H;
		Comparator<State<T>> sComparator = new StateComparator<T>();
		openList = new PriorityQueue<State<T>>(sComparator);
	}

	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> search) {
		
		openList.add(search.getInitialState());
		close = new HashSet<State<T>>();

		while (!(openList.isEmpty())) {
			State<T> state = popOpenList();
			close.add(state);

			 // private method, back traces through the parents
			if (state.equals(search.getGoalState()))
				return backTrace(search.getInitialState(),state );
			
			//Check the successors for index specific
			ArrayList<State<T>> successors = search.getAllPossibleStates(state);

			for (State<T> currentState : successors) {
				//Check for successors specific if it white add it to the priority queue
				if (!close.contains(currentState) && !openList.contains(currentState)) {
					currentState.setCameFrom(state);
					// calculat the cost of the currentState together with the heuristic
					currentState.setCost(state.getCost() +  heuristic.getCostHeuristic(search.calcAirdis(currentState), search.getCostValue()));
					openList.add(currentState);
				}
				//Check if the Connection between the currentState and the specific index is bather then the cost that it all ready have 
				else if (state.getCost() + heuristic.getCostHeuristic(search.calcAirdis(currentState), search.getCostValue()) < currentState.getCost()) {
					if (!openList.contains(currentState)) {
						openList.add(currentState);
					}
					else {
						currentState.setCost(state.getCost() + heuristic.getCostHeuristic(search.calcAirdis(currentState), search.getCostValue()));
						currentState.setCameFrom(state);
					}
				}
			}
		}

		return null;
	}

	@Override
	protected State<T> popOpenList() {
		increaseByOne();
		return openList.poll();
		
	}
}
