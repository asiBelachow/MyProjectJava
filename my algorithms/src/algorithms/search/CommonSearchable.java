package algorithms.search;

import java.util.ArrayList;


/**
 * The Class CommonSearchable.
 *
 * @param <T> the generic type
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public abstract class CommonSearchable<T> implements Searchable<T> {

	//------------------------------Data Members-------------------------//
	
	protected double costValue;
	
	//------------------------------Constructors-------------------------//
	
	public CommonSearchable() {
		setCostValue(1);
		
	}
	

	public CommonSearchable(double cost) {
		setCostValue(cost);
		
	}
	

	//-----------------------------setters and getters-------------------//
	
	
	

	public void setCostValue(double costValue) {
		this.costValue = costValue;
	}
	


	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getCostValue()
	 */
	@Override
	public  double getCostValue(){
		return costValue;
	}
	
	//-------------------------------Functionality------------------------------//
	
	@Override
	public abstract State<T> getInitialState();


	@Override
	public abstract State<T> getGoalState();


	@Override
	public abstract ArrayList<State<T>> getAllPossibleStates(State<T> s);
	


	
}
