package view;

import java.io.IOException;

import controller.Controller;

public class MyView extends MyCommonView {
	
	
	//------------------------------Constructors-------------------------//
	
	public MyView(Controller c) {
		super(c);
	}

	
	
	
	//-----------------------------setters and getters-------------------//
	
	
	
	
	
	
	
	//-------------------------Functionality-------------------------//
	
	
	@Override
	public void forwardCommand(String command, String[] param) throws IOException{
		//Forward command that client entered to the controller 
		c.forwardCommand(command, param);
		
	}
	
@Override
	public void displaySolution(String solution) {
		//Forward the solution to the CLI
		cli.displaySolution(solution);
		
	}
	
	
}
