package model;


import java.util.HashMap;
import java.util.Observable;


/**
 * <h1>AbstractModel</h1><p>
 * This class defines the common functionality of the model in MVP architectural pattern</br>
 * Manages the data, logic and rules of the MVP architectural pattern </p>
 * <b>Data members :</b>
 * <li><b>data</b> - HashMap<String, Object> hold the commands</br>
  * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractModel extends Observable implements Model {
	
	//------------------------------Data Members-------------------------//
	
	HashMap<String, Object> data;
	

	//------------------------------Constructors-------------------------//
	


	/**
	 *<h1>MyCommonModel</h1><p>
	 * <i><ul>MyCommonModel(Controller cont)<i><p>
	 * Initialize a new Model
	 */
	public AbstractModel() {
		data = new HashMap<String, Object>();
	}
	

	
	//-----------------------------Setters and Getters-------------------//

	/**
	 *<h1>getData</h1><p>
	 * <i><ul>HashMap<String, Object> getData()<i><p>
	 *	Get the HashMap that store the commands
	 */
	public HashMap<String, Object> getData() {
		return data;
	}


	/**
	 *<h1>setData</h1><p>
	 * <i><ul>HashMap<String, Object> setData()<i><p>
	 *	Set the HashMap that store the commands
	 */
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	//-------------------------Functionality-------------------------//
	
	/**
	* <h1>setCommandAndNotify</h1><p>
	 * <h1><ul>void setCommandAndNotify(String command, Object args)</h1><p>
	 * Puts the command and data in a HashMap and notifies
	 * @param command - command to notify
	 * @param data - data to save for when the client asks using {@link #getCommandData(String)} to get the data
	 */
	protected void setCommandAndNotify(String command, Object args)
	{
		if (data!=null)
			data.put(command, args);
		setChanged();
		notifyObservers(command);
	}
	
	
	@Override
	public abstract void writeToServer(String command,Object data);
		
	
	@Override
	public Object getCommandData(String command){
		return data.get(command);
	}

	

}
