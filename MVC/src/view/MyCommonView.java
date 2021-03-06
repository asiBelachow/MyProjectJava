package view;

import java.io.IOException;



import controller.Controller;

public abstract class MyCommonView implements View {
	
	
	protected Controller c;
	
	protected CLI cli;
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 *<h1>MyCommonView</h1><p>
	 * <i><ul>MyCommonView(Controller cont)<i><p>
	 * Initialize a new View
	 * @param Controller
	 */
	public MyCommonView(Controller c) {
		this.c = c;
	}


	
	
	//-----------------------------setters and getters-------------------//
	
	public Controller getController() {
		return c;
	}


	public void setController(Controller c) {
		this.c = c;
	}
	
	public CLI getCli() {
		return cli;
	}


	public void setCli(CLI cli) {
		this.cli = cli;
	}
	
	
	//-------------------------Functionality-------------------------//
	
	@Override
	public void start() {
	
		cli.start();
		
	}
	
	@Override
	public abstract void forwardCommand(String command, String[] parm) throws IOException;

	@Override
	public abstract void displaySolution(String solution);
	



	
	

}
