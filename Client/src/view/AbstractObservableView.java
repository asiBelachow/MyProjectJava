package view;

import java.util.HashMap;
import java.util.Observable;
import view.cli.CLI;
import commands.Command;


/**
 * <h1>AbstractObservableView</h1><p>
 * This class defines the common functionality of the view part<br>
 *  of the Graphic User Interface and Command Line Interface in our MVP architecture
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractObservableView extends Observable implements View {
	
	//------------------------------Data Members-------------------------//
	
	/** The cli. */
	protected CLI cli;
	
	protected HashMap<Command, Object> commands;
	
	
	/**
	 *<h1>MyCommonModel</h1><p>
	 * <i><ul>MyCommonModel(Controller cont)<i><p>
	 * Initialize a new abstract observable view.
	 */
	
	public AbstractObservableView() {
		commands = new HashMap<Command, Object>();

	}
	
	//-------------------------Setters And Getters-------------------------//
	
	/**
	 * <h1>Get Cli</h1><p>
	 * <i>CLI getCli()<i><p>
	 * get the data member cli.
	 * @return the data member cli {@link CLI}
	 */
	public CLI getCli() {
		return cli;
	}

	/**
	 * <h1>Set Cli</h1><p>
	 * <i>CLI setCli()<i><p>
	 * set the data member cli.
	 * @param cli - {@link CLI}
	 */
	public void setCli(CLI cli) {
		this.cli = cli;
	}
	
	
	//-------------------------Functionality-------------------------//

	/**
	* <h1>setCommandAndNotify</h1><p>
	 * <h1>void setCommandAndNotify(String command, Object args)</h1><p>
	 * Puts the command and data in a HashMap and notifies
	 * @param command - command to notify
	 * @param data - data to save for when the client asks using {@link #getCommandData(String)} to get the data
	 */
	protected void setCommandAndNotify(Command command, Object args) {
		if (args != null)           
			commands.put(command, args);
		setChanged();
		notifyObservers(command);
	}

	@Override
	public Object getCommandData(Command command) {
		return  commands.get(command);
	}
	

	


	
	
	
	

}
