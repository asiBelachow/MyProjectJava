package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import commands.Command;
import commands.CommandManger;
import model.Model;
import view.View;

public abstract class AbstractPresenter implements Observer,Presenter {
	
	//------------------------------Data Members-------------------------//
	
	protected Model model;
	protected View view;
	protected CommandManger commandManger;
	protected HashMap<String, Command> commands;
	protected HashMap<String, String> regexCommands;

	
	//------------------------------Constructors-------------------------//
	


	public AbstractPresenter(Model model, View view) {
		this.model = model;
		this.view = view;
		this.commandManger = new CommandManger(model, view);
		initCommands();
		initRegexCommand();
	}
	
	//-----------------------------setters and getters-------------------//
	
	
	public HashMap<String, String> getRegexCommands() {
		return regexCommands;
	}

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
	
	public HashMap<String, Command> getCommands() {
		return commands;
	}
	
	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}
	
	//-------------------------Functionality-------------------------//

	
	@Override
	public void initCommands(){
		setCommands(commandManger.getCommandMap());
	}
	
	public void initRegexCommand(){
		setRegexCommands(commandManger.getRegexCommand());
		
	}


	@Override
	public abstract void update(Observable o, Object args);


	

}