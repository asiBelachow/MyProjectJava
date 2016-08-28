package algorithms.search;

import java.util.ArrayList;


 /**
  * <h1>The Interface Searchable</h1><p>
  * A class implementing the required methods will allow to <br>
  * Searcher algorithms to search a solution on that class 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
  */
public interface Searchable<T> {
	
	/**
	 *<h1>get Initial State</h1><p>
	 * <i><ul>State<T> getInitialState()<i><p>
	 * Get the start state from a domain-independent problems<br>
	 * @return State
	 */
	public State<T> getInitialState();
	
	/**
	 *<h1>get Goal State</h1><p>
	 * <i><ul>State<T> getGoalState()<i><p>
	 * Get the goal state from a domain-independent problems<br>
	 * @return State
	 */
	public State<T> getGoalState();
	
	
	/**
	 *<h1>Get All Possible States</h1><p>
	 * <i><ul>ArrayList<State<T>> getAllPossibleStates(State<T> s)<i><p>
	 * Get all possible state from a given state<br>
	 * @param State s
	 * @return ArrayList of states - the possible moves
	 */
	public ArrayList<State<T>> getAllPossibleStates(State<T> s);
	
	
	
	/**
	 *<h1>Get Cost Value</h1><p>
	 * <i><ul>double getCostValue()<i><p>
	 * Get the cost of passage from one state to another state<br>
	 * @param State s
	 * @return ArrayList of states - the possible moves
	 */
	public double getCostValue();
}
