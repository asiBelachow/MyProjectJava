package presenter;


import java.io.IOException;
import java.util.Observable;
import commands.Command;
import model.Model;
import model.MyModel;
import view.View;



/**
 * <h1>MyPresenter</h1><p>
 * A presenter class in our MVP system, communicates with<br>
 * the view using command interface (with added regex check for flexibility),<br>
 * and with the model using string commands(because flexibility is not needed<br
 *  between model and presenter).
 */
public class MyPresenter extends AbstractPresenter {


	
	/**
	 * <h1>My Presenter</h1><p>
	 * <i>MyPresenter(Model model, View view)<i><p>
	 * Instantiates a new  Presenter
	 * @param model the {@link MyModel}
	 * @param view the view
	 */
	public MyPresenter(Model model, View view) {
		super(model, view);
		
	}


	@Override
	public void update(Observable o, Object args) {
		
		
		
		
		//Get the command without the parameters
		String commandLine = (String) args;
		String arr[] = commandLine.split(" ");
		String command = arr[0];
	
		//Check if the view notify 
		if( o== view){
			//check if the command found
			if(!regexCommands.containsKey(command))
			{
				String msg = "You entered unrecognized command (\"" + command+"\") for help enter \"menu\"";
				view.displayMessage(msg);
			}
			else{
				//Check if the parameters match to to regular expression of the command
				if(!checkRegexCommand(command,commandLine)){
					String msg = "You entered in valid parameters (\"" + commandLine+"\") for help enter \"menu\"";
					view.displayMessage(msg);
					return;
				}
				else{
					//Execute the command
					String c = regexCommands.get(command);
					Command cmd = commands.get(c);
					System.out.println(cmd.toString());
					try {
						cmd.doCommmand(arr);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}//Check if the model notify 
		if (o==model){
			
			//Check if the parameters match to to regular expression of the command
			if(regexCommands.containsKey(command))
			{
				String[] arg = null;
				if (arr.length > 1) {
					String commandArgs = commandLine.substring(commandLine.indexOf(" ") + 1);
					arg = commandArgs.split(" ");
					arg[0]=commandArgs;
				}
				//Excuse the command
				String c = regexCommands.get(command);
				Command cmd = commands.get(c);
				System.out.println(cmd.toString());
				try {
					cmd.doCommmand(arg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				
			}
			
		}
	
	}
			
	
	/**
	 * <h1>Check Regex Command</h1><p>
	 * <i>boolean checkRegexCommand(String command,String commandLine)<i><p>
	 * Get a command and command with parameters and checks<br>
	 * if the parameters match to the regular expression of the command
	 * @param command the command
	 * @param commandLine the command line
	 * @return true, if match
	 */
	private boolean checkRegexCommand(String command,String commandLine) {
	
		// matching all regular expressions with the given user command
		String regex = regexCommands.get(command);
		return commandLine.matches(regex);
		
	}
	

}
