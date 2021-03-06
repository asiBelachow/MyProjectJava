package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;


/*
Advantages of - Best-First Search
 1) Takes advantage of domain information to guide search
 2) Greedy advance to the goal 

Advantages of - Best-First SearchDepth first search
 1) May arrive at solutions without examining much of search space
 2) Needs little memory (only node in current path needs to be stored)

I choose to implement best first search with a priority queue because we always want the 
less cost step to the the target (goal position)

*/

/**
 * <h1>BestFirstSearch</h1><p>
 * This class extends CommonSearcher class and implements best first search algorithm
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class BestFirstSearch<T> extends CommonSearcher<T> {
	
	//------------------------------Data Members-------------------------//
	
	protected PriorityQueue<State<T>> open;
	
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>Best First Search</h1><p>
	 * <i><ul>BestFirstSearch()<i><p>
	 * 	
	 * Initial a new priority queue 
	 * 
	 */
	public BestFirstSearch() {
		super();
		Comparator<State<T>> sComparator = new StateComparator<T>();
		open = new PriorityQueue<State<T>>(sComparator); 
		close = new  HashSet<State<T>>();
	}
	
	
	//-------------------------------Functionality------------------------------//
	@Override
	public Solution<T> search(Searchable<T> s) {

		//Add the start state of searchable domain-independent problems
		open.add(s.getInitialState());

		while( !open.isEmpty()){
			//Get a state from the priority queue
			State<T> n = popOpenList();
			//Add the state to the close hash set
			close.add(n);

			//if we achieved the goal state
			if( n.equals(s.getGoalState()))
				return backTrace(s.getInitialState(), n);

			ArrayList<State<T>> successors = s.getAllPossibleStates(n);

			for( State<T> state : successors){

				if(!close.contains(state) && !open.contains(state)){
					state.setCameFrom(n);
					setNewCost(state);
					open.add(state);
				}
				else 
				{
					if ( state.getCost() < ( n.getCost() + s.getCostValue())){

						if(!open.contains(state)){
							setNewCost(state);
							state.setCameFrom(n);
							open.add(state);
						}

						else
							adjustCost(state);

					}	
				}
			}
		}
		return null;

	}

	/**
	 *<h1>pop</h1><p>
	 * <i><ul>State<T> pop()<i><p>
	 * Get a state from the the container and<br>
	 * update the number of evaluated nodes
	 * @return State
	 */
	@Override
	protected State<T> popOpenList() {
		increaseByOne();
		return open.poll();
	}
	
	

	
	/**
	 *<h1>Adjust Cost</h1><p>
	 * <i><ul>void adjustCost(State<T> state)<i><p>
	 * The method searches for the given State in the given queue and <br> changes
	 * its cost and cameFrom members.
	 * @param State - A State to be searched in the queue.
	 */
	protected void adjustCost(State<T> state) {
		Iterator<State<T>> itr = open.iterator();
		State<T> newState = null;
		
		while(itr.hasNext()){
			newState = itr.next();
			if(newState.equals(state))
			{
				open.remove(newState);
				setNewCost(newState);
				open.add(newState);
				
				return;
			}
			
		}
		
	}
	
	
	
	
	
	
}