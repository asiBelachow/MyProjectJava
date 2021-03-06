package view;


import java.io.BufferedReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import allCommands.Command;

public class CLI extends Thread {
	
	private static final String EXIT_COMMAND = "exit";
	
	BufferedReader in;
	PrintWriter out;
	
	View v;
	
	private HashMap<String, Command> commandMap;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>CLI</h1><p>
	 * <i><ul>CLI(	BufferedReader in, PrintWriter out, HashMap<String,Command> map)<i><p>
	 * Initialize a CLI.
	 * @param in -  BufferedReader
	 * @param out - PrintWriter
	 * @param map - HashMap<String,Command>
	 */
	public CLI(	BufferedReader in, PrintWriter out,View v, HashMap<String,Command> map) {
		this.in = in;
		this.out = out;
		this.v = v;
		this.commandMap = map;
		
	}
	
	//-----------------------------setters and getters-------------------//

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public HashMap<String, Command> getCommandMap() {
		return commandMap;
	}

	public void setCommandMap(HashMap<String, Command> commandMap) {
		this.commandMap = commandMap;
	}
	
	//-------------------------Functionality-------------------------//
	
	
	
	
	@Override
	public void start() {
		//Get an input from the client
		out.println("*To view commands enter menu");
		out.printf("Please enter command: ");
		String buffer;
		boolean flag=false;
		try { 
			//get input until the input equals to exit
			while(!(buffer=in.readLine()).equals(EXIT_COMMAND)){
				
				
				Iterator<String> iter = commandMap.keySet().iterator();
				//Checks if the commands the input that the user entered match to one of the element in the commandmap
				while (iter.hasNext()){
					String command = iter.next();
					//If  matches forward the command to the view
					if(buffer.matches(command)){
						out.println("The process in progress...");
						v.forwardCommand(command, buffer.split(" "));
						out.printf("\nPlease enter command: ");
						flag=true;
						break;
					}
				}
				if(flag == false){
					out.println("\n\nCommand \""+ buffer +"\" not found");
					out.printf("\nPlease enter command: ");
				}
				
			}
			v.forwardCommand(buffer, buffer.split(" "));

		}catch (Exception e) {
			e.printStackTrace();
		}



	}
	
	public void displaySolution(String solution){
			out.println(solution);
	}
	

}
