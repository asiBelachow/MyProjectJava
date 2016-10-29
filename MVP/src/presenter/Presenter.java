package presenter;


import model.MyModel;


/**
 * <h1>The Interface Presenter</h1></br>
 * This interface is the presenter part of our MVP architecture</br>
 * used for operates the model ({@link MyModel}) and updates the view with the results of the operation </br>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public interface Presenter {
	

	/**
	 * <h1>Initial Commands</h1><p>
	 * <i><ul>void initCommands()<i><p>
	 *  This method initialize the presenter with the<br> 
	 *  command that the model ({@link MyModel}) can communicate <br>
	 *  with the view and the model
	 */
	public void initCommands();
	
	
	/**
	 * <h1>Initial Regex Commands</h1><p>
	 * <i><ul>void initRegexCommand()<i><p>
	 *  This method initialize the presenter with the<br> 
	 *  regular expression that the presenter need in order to <br>
	 *  match the command from the model ({@link MyModel}) and view  
	 */
	public void initRegexCommand();
	
}
