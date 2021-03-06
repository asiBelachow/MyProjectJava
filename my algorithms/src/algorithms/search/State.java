package algorithms.search;

import java.io.Serializable;



/**
 * <h1>State<T></h1><p>
 * This class implements the Comparable interface and its define state of given search problem (Maze3D)
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class State<T> implements Serializable,Comparable<State<T>>{//implements Comparable<State<T>>{

	//------------------------------Data Members-------------------------//
	
	private static final long serialVersionUID = -428403587808162206L;

	private T state;
	
	private double cost;
	
	private State<T> cameFrom;
	

	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>Default Constructor</h1><p>
	 * Initialization a new state
	 */
	public State() {
		
	}
	/**
	 * <h1>Constructor</h1><p>
	 * Initialization a new state
	 * @param state 
	 * @param cost - double
	 * @param cameFron State<T>
	 */
	public State(T state) {
		
		setState(state);
		setCost(1);
		setCameFrom(null);	
	}
	
	
	/**
	 *<h1>Copy Constructor</h1><p>
	 *Create copy of a given state
	 * @param s - State<T>
	 */
	public State(State<T> s) {
		setState(s.getState());
		setCost(s.getCost());
		setCameFrom(s.getCameFrom());
	}
	
	//-----------------------------setters and getters-------------------//

	public T getState() {
		return state;
	}

	public void setState(T state) {
		this.state = state;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public State<T> getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	
	//-------------------------------Functionality------------------------------//
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State)) {
			return false;
		}
		
		@SuppressWarnings("unchecked")
		State<T> state = (State<T>) obj;
		
		if (this.getState().equals(state.getState())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return getState().toString();
	}


	@Override
	public int compareTo(State<T> s) {
		return (int) (getCost() - s.getCost());
	};
	
	@Override
	public int hashCode(){
		return state.toString().hashCode();
				
	}
	
	
}
