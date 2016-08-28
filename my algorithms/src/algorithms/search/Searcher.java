package algorithms.search;



/**
 * <h1>The Interface Searcher</h1><p>
 * Searcher interface define the functionality that needed in <br>
 * order to search upon Searchable domain-independent problems
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public interface Searcher<T> {
	
	
	
	
	/**
	 *<h1>Search</h1><p>
	 * <i><ul>Solution<T> search(Searchable<T> s)<i><p>
	 *
	 * Search for solution in a given domain searchable-independent problem
	 * 
	 * @param searchable - domain searchable independent problem
	 * @return Solution - the sequence of the states needed to solve the problem (route from start to end)
	 */
	public Solution<T> search(Searchable<T> s);
	
	
	
	/**
	 * 
	 *<h1>Gets the number of nodes evaluated</h1><p>
	 * <i><ul>int getNumberOfNodesEvaluated()<i><p>
	 * Used to determine the number of states the search algorithm evaluated.
	 * @return the number of nodes evaluated
	 */
	public int getNumberOfNodesEvaluated();
	

}
