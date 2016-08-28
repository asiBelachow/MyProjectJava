package algorithms.search;

import java.util.HashSet;

/**
 * <h1>CommonSearcher</h1><p>
 *  CommonSearcher Class define the common functionality between search algorithms<br><p>
 *  <b>Data members:</b>
 * <ul> 
 * <li> a priority queue hold the states that we visited
 * <li> a hash set hold the states אישא we finish to process
 * <li>	the number of state the searcher achive
 * <li>
 * </ul>
 *	<p>
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public abstract class CommonSearcher<T> implements Searcher<T> {
	
	private int evaluatedNodes;
	protected  Solution<T> solution;
	protected HashSet<State<T>> close;
	/**
	 *<h1>Common Searcher</h1><p>
	 * <i><ul>CommonSearcher()<i><p>
	 * Initialize a new common searcher
	 */
	//------------------------------Constructors-------------------------//
	public CommonSearcher() {
		evaluatedNodes = 0;
		solution = new Solution<T>();
	}


	
	//-------------------------------Functionality------------------------------//
	
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	

	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
	
	

	/**
	 * The method traces back through the cameFrom reference to <br> determine a series of States to solve the problem.
	 *<h1>BackTrace</h1><p>
	 * @param start - The starting State of the problem
	 * @param goal the goal - The goal State of the problem
	 * @return Solution - The solution of the problem (in States)
	 */
	protected Solution<T> backTrace(State<T> start, State<T> goal){
		solution.getSolution(start, goal);
		return solution;
	}
	
	protected void increaseByOne(){
		evaluatedNodes++;
	}
	
	/**
	 *<h1>Common Searcher</h1><p>
	 * <i><ul>CommonSearcher()<i><p>
	 * Initialize a new common searcher
	 */
	protected abstract State<T> popOpenList();

	
	
	/**
	 *<h1>Set New Cost</h1><p>
	 * <i><ul>void setNewCost(State<T> s)<i><p>
	 * setting the given state its f() value.
	 * @param s - State.
	 */
	protected void setNewCost(State<T> s) {
		s.setCost(s.getCameFrom().getCost() + s.getCost());
		
	}
	
	
	
}
