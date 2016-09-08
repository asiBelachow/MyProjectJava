package algorithms.search;

import java.util.ArrayList;

/**
 * <h1>Solution</h1><p>
 * Solution Class calculate the solution for any searchable  domain-independent problems <br>
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class Solution<T> {
	
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
