package algorithms.search;


import java.util.HashSet;
import java.util.Stack;


/**
 * The Class DepthFirstSearch.
 *
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class DepthFirstSearch<T> extends CommonSearcher<T> {


	Stack<State<T>> white;


	public DepthFirstSearch() {
		super();
		white = new Stack<State<T>>();
		close = new HashSet<State<T>>();
	
	}
	
	@Override
	public Solution<T> search(Searchable<T> s) {

		//Add the start state of searchable domain-independent problems
		white.push(s.getInitialState());
	
		
		while (!white.isEmpty()){
	
			State<T> state = popOpenList();
			close.add(state);
			
			if(state.equals(s.getGoalState())){
				return backTrace(s.getInitialState(), state);
			}
			
	
			for( State<T> st : s.getAllPossibleStates(state)){
				if( !close.contains(st))// && !gray.contains(st))
				{
					white.push(st);
					st.setCameFrom(state);
				}
				
			}	
	
		}
		
		
		return null;
		
		
	/*	dfs(s, s.getInitialState());
		return solution;*/
	}
	
	
	@Override
	protected State<T> popOpenList() {
		increaseByOne();
		return white.pop();
	}
	
	@Override
	protected void setNewCost(State<T> s) {
		// TODO Auto-generated method stub
		
	}
	
	/*private void dfs(Searchable<T> s, State<T> state){
		
		if(state.equals(s.getGoalState())){
			
			solution = backTrace(s.getInitialState(), state);
			return;
		}
		
		close.add(state);
		
		ArrayList<State<T>> actions = s.getAllPossibleStates(state);
		for(State<T> neighbor: actions)
		{
			if (!close.contains(neighbor)) {
				neighbor.setCameFrom(state);
				dfs(s, neighbor);					
			} 			
		}
		return;
		
	}*/
	
	
	
	

}
