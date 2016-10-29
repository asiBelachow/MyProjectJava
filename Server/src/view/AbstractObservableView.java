package view;

import java.util.HashMap;
import java.util.Observable;




/**
 * <h1>class AbstractObservableView</h1><p>
 * This class defines the common functionality of the view part<br>
 *  of the Graphic User Interface and Command Line Interface in our MVP architecture
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractObservableView extends Observable implements View {
	
	//-------------------------Data Members-------------------------//
	
	protected HashMap<String, Object> data;
	
	/**
	 *<h1>MyCommonModel</h1><p>
	 * <i><ul>MyCommonModel(Controller cont)<i><p>
	 * Initialize a new abstract observable view.
	 */
	
	//------------------------------Constructors-------------------------//
	
	public AbstractObservableView() {
	
		data = new HashMap<String, Object>();

	}
	
	//-------------------------Functionality-------------------------//

	

	protected void setCommandAndNotify(String command, Object args) {
		if (args != null)
			data.put(command, args);
		setChanged();
		notifyObservers(command);
	}

	@Override
	public Object getCommandData(String command) {
		return data.get(command);
	}


	
	
	
	

}
