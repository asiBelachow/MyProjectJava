package presenter;


import java.util.HashMap;
import commands.Command;
import model.MyModel;
import view.View;
import model.Model;


/**
 * <h1>The Interface Presenter</h1></br>
 * This interface is the presenter part of our MVP architecture used for operates</br>
 * the {@link Model} and updates the {@link View} with the results of the operation and vice versa
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public interface Presenter {
	
	
	/**
	 * <h1>initCommands</h1><p>
	 * <i><ul>void initCommands()<i><p>
	 *  This method initialize the presenter with the<br> 
	 *  command that the ({@link MyModel}) can execute<br>
	 *  
	 */
	public void initCommands(HashMap<String, Command> commands);
	

	
}
