package view.cli;


import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import presenter.MyPresenter;

import view.View;



/**
 * <h1>The Class CLI</h1><p>
 * This class is the client part of Command Design Pattern<br>
 * Get an command from the user a pass it to the<br>
 *  {@link MyPresenter} for process
 * 
 */
public class CLI extends Observable implements Closeable {
	
	//------------------------------Data Members-------------------------//
	
	
	private static final String EXIT_COMMAND = "exit";
	
	BufferedReader in;
	
	PrintWriter out;
	
	View v;
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>CLI </h1><p>
	 * <i><ul>CLI(BufferedReader in, PrintWriter out)<i><p>
	 * Initialize a new CLI.
	 * @param in -  BufferedReader
	 * @param out - PrintWriter
	 */
	public CLI(	BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	
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

	
	
	
	//-------------------------Functionality-------------------------//
	

	
	public void start(){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					String input;
					out.println("************************************************************");
					out.println("*                   Command Line Interface                 *");
					out.println("************************************************************");
					out.println("*To view commands enter menu");
					out.printf("Please enter command: ");
					out.flush();
					while(!(input=in.readLine()).equals(EXIT_COMMAND)){
						setChanged();
						notifyObservers(input);
						out.printf("\nPlease enter command: ");
						out.flush();
					}
					setChanged();
					notifyObservers(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				
			}
		}); 
		thread.start();
			
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
