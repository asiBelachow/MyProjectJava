package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import commands.Command;
import commands.CommandManger;
import model.Model;
import model.MyModel;
import view.View;


/**
 *  <h1>class Abstract Presenter</h1><p>
 *  This class defines the common functionality in order to</br>
 *  connect between the {@link Model} and the {@link View} </p>
 *  <b>Data members :</br></p>
 *  <li>{@link View}</br>
 *  <li>{@link Model}</br>
 *  <b>Data structure :</b></p>
 *  <li>HashMap<String, Command> commands</br>
 *  <li>HashMap<String, String> regexCommands</br>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractPresenter implements Observer,Presenter {
	
	//------------------------------Data Members-------------------------//
	
	protected Model model;
	protected View view;
	protected CommandManger commandManger;
	protected HashMap<String, Command> commands;
	protected HashMap<String, String> regexCommands;

	
	//------------------------------Constructors-------------------------//
	

	/**
	 * <h1>Abstract Presenter</h1><p>
	 * <i><ulAbstractPresenter(Model model, View view)<i><p>
	 * Instantiates a new Abstract Presenter
	 * @param model the {@link MyModel}
	 * @param view the view
	 */
	public AbstractPresenter(Model model, View view) {
		this.model = model;
		this.view = view;
		this.commandManger = new CommandManger(model, view);
		initCommands();
		initRegexCommand();
	}
	
	//-----------------------------setters and getters-------------------//
	
	/**
	 * <h1>Get Regex Command</h1><p>
	 * <i><ul>HashMap<String, String> getCommands()<i><p>
	 * Get the data member regexCommands
	 * @return HashMap<String, String> - regexCommands 
	 */
	public HashMap<String, String> getRegexCommands() {
		return regexCommands;
	}
	
	/**
	 * <h1>Set Regex Command</h1><p>
	 * <i><ul>void setRegexCommands(HashMap<String, String> regexCommands)<i><p>
	 * Set the data member regexCommands
	 */
	public void setRegexCommands(HashMap<String, String> regexCommands) {
		this.regexCommands = regexCommands;
	}
	
	
	/**
	 * <h1>Set model</h1><p>
	 * <i><ul>void setModel(Model m)<i><p>
	 * Set the data member {@link Model} m
	 * @param m - the  model
	 */
	public void setModel(Model model){
		this.model = model;
	}
	
	
	/**
	 * <h1>Set view</h1><p>
	 * <i><ul>void setView(View v)<i><p>
	 * Set the data member {@link View} v
	 * @param v - the view 
	 */
	public void setView(View view){
		this.view = view;
		
	}
	
	/**
	 * <h1>Get Command</h1><p>
	 * <i><ul>HashMap<String, Command> getCommands()<i><p>
	 * Get the data member commands
	 * @return HashMap<String, Command> - commands 
	 */
	public HashMap<String, Command> getCommands() {
		return commands;
	}
	
	/**
	 * <h1>Set Command</h1><p>
	 * <i><ul>void setCommands(HashMap<String, Command> commands)<i><p>
	 * Set the data member commands
	 */
	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}
	
	//-------------------------Functionality-------------------------//

	
	@Override
	public void initCommands(){
		setCommands(commandManger.getCommandMap());
	}
	
	@Override
	public void initRegexCommand(){
		setRegexCommands(commandManger.getRegexCommand());
		
	}


	@Override
	public abstract void update(Observable o, Object args);



}
