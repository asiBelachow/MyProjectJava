package model;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


/**
 *  <h1>AbstractClientHandler</h1><p>
 *  This class defines the common functionality in order to execute clients request
 * 
 */
public abstract class AbstractModel extends Observable implements Model,Observer{
	
	//------------------------------Data Members-------------------------//
	
	protected HashMap<String, Object> data;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 *<h1>AbstractModel()</h1><p>
	 * <i><ul>AbstractModel()<i><p>
	 * Initialize a new AbstractModel
	 */
	public AbstractModel() {
		data = new HashMap<String, Object>();
	}


	//-------------------------Functionality-------------------------//
	
	/**
	 * <h1>setCommandAndNotify</h1><p>
	 * <i><ul>void setCommandAndNotify(String command, Object data)<i><p>
	 * Insert the command and the parameters/Object to the HashMap
	 * and notify the Observers about the changes
	 * @param command - the command
	 * @param data - the parameters/object to pass
	 */
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
