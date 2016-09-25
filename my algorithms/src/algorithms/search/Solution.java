package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

import algorithms.maze3DGenerators.Position;

/**
 * <h1>Solution</h1><p>
 * Solution Class calculate the solution for any searchable  domain-independent problems <br>
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class Solution<T> implements Serializable {
	
	//------------------------------Data Members-------------------------//
	
	private static final long serialVersionUID = -2104334895564894181L;
	
	private ArrayList<State<T>> solution;
	
	//------------------------------Constructors-------------------------//

	
	/**
	 *<h1>Solution</h1><p>
	 * <i><ul>Solution()<i><p>
	 * Initialize a new solution
	 */
	public Solution() {
		solution =  new ArrayList<State<T>>();
	}
	
	
	//-------------------------------Functionality------------------------------//
	
	
	/**
	 *<h1>Get Solution</h1><p>
	 * <i><ul>getSolution(State<T> start, State<T> goal)<i><p>
	 * A recursion method to backtrace the solution path 
	 * @param start the start
	 * @param goal the goal
	 * @return the solution
	 */
	public void  getSolution(State<T> start, State<T> goal){
		
		if( start.equals(goal)){
			solution.add(start);
			return ;
		}
		
		getSolution(start, goal.getCameFrom());
		solution.add(goal);
		
	}
	
	public ArrayList<Position> getArraySolution(){
		ArrayList<Position> array = new ArrayList<Position>();
		
		for(int i=0;i<solution.size();i++){
			array.add((Position) solution.get(i).getState());
		}
		return array;
	}
	
	
	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();
		for( int i=0; i<solution.size(); i++){
			
			str.append(""+ solution.get(i).getState()+" ");
		}
		
		str.append("\n");
		
		return str.toString();
	}
	
	
	
}
