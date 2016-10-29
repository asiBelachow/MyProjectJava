package view.cli;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import commands.Command;
import presenter.MyPresenter;


/**
 * <h1>CLI</h1><p>
 * This class is the client part of Command Design Pattern<br>
 * Get an command from the user a pass it to the<br>
 *  {@link MyPresenter} for process
 * 
 */
public class CLI implements Closeable {
	
	//------------------------------Data Members-------------------------//
	
	private BufferedReader in;
	
	private PrintWriter out;

	private HashMap<String, Command> commands;
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>CLI </h1><p>
	 * <i><ul>CLI(BufferedReader in, PrintWriter out)<i><p>
	 * Initialize a new CLI.
	 * @param in -  BufferedReader
	 * @param out - PrintWriter
	 */
	public CLI(	BufferedReader in, PrintWriter out, HashMap<String, Command> commands) {
		this.in = in;
		this.out = out;
		this.commands = commands;
		
	
	}
	
	//-----------------------------setters and getters-------------------//

	
	/**
	 * <h1>getCommands</h1><p>
	 * <i><ul>HashMap<String, Command> getCommands()<i><p>
	 * Get the HashMap that hold all the commands.
	 * @return HashMap commands
	 */
	public HashMap<String, Command> getCommands() {
		return commands;
	}

	/**
	 * <h1>setCommands</h1><p>
	 * <i><ul>HashMap<String, Command> setCommands()<i><p>
	 * Set the HashMap that hold all the commands
	 */
	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}

	/**
	 * <h1>getIn</h1><p>
	 * <i><ul>BufferedReader getIn()<i><p>
	 * Get the BufferedReader.
	 * @return the BufferedReader
	 */ 
	public BufferedReader getIn() {
		return in;
	}

	/**
	 * <h1>setIn</h1><p>
	 * <i><ul>void setIn(BufferedReader in)<i><p>
	 * Set the BufferedReader
	 * @return the BufferedReader
	 */ 
	public void setIn(BufferedReader in) {
		this.in = in;
	}

	/**
	 * <h1>getOut</h1><p>
	 * <i><ul>PrintWriter getOut()<i><p>
	 * Get the PrintWriter
	 * @return the PrintWriter
	 */ 
	public PrintWriter getOut() {
		return out;
	}

	/**
	 * <h1>setOut</h1><p>
	 * <i><ul>PrintWriter setOut()<i><p>
	 * Set the PrintWriter.
	 * @param out - PrintWriter
	 */ 
	public void setOut(PrintWriter out) {
		this.out = out;
	}

	

	//-------------------------Functionality-------------------------//
	
	/**
	 * <h1>Get Command By Input</h1><p>
	 * <i><ul>Command getCommandByinput(String input)<i><p>
	 * returns (if found) a command mapped to a regex as the input
	 * @param input - user input
	 * @return Command instance if found by regular expression (or null)
	 */
	public Command getCommandByInput(String input){
		boolean commandOk = false;
		String command = null;

		// matching all regular expressions with the given user command
		Iterator<String> regexIterator = commands.keySet().iterator();
		while (regexIterator.hasNext() && !commandOk) {
			command = regexIterator.next();
			commandOk = input.matches(command);
		}
		if (commandOk)
			return commands.get(command);
		else
			return null;
	}


	@Override
	public void close() throws IOException {
		if (out != null)
			out.close();
		if (in != null)
			in.close();
		System.out.println("CLI Closed!!!!!!");
		
	}
	
	

	
	
	
	
	
	
	

}
