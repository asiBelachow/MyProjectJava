package algorithms.search;

import java.util.Comparator;

/**
 * The Class StateComparator.
 *
 * @param <T> the generic type
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-23-08
 */
public class StateComparator<T> implements Comparator<State<T>> {

	@Override
	public int compare(State<T> s1, State<T> s2) {
		
		return (int)((s1.getCost() - s2.getCost()));

	}

}
