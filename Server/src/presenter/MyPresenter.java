package presenter;


import java.util.Observable;
import model.MyModel;
import model.ServerModel;
import view.View;


/**
 * <h1>MyPresenter</h1><p>
 * A presenter class in our MVP system, communicates with<br>
 * the view using command interface (with added regex check for flexibility),<br>
 * and with the model using string commands(because flexibility is not needed<br
 *  between model and presenter).
 */
public class MyPresenter extends AbstractPresenter {
	

	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>My Presenter</h1><p>
	 * <i>MyPresenter(Model model, View view)<i><p>
	 * Instantiates a new  Presenter
	 * @param model the {@link MyModel}
	 * @param view the view
	 */
	public MyPresenter( ServerModel model,View view) {
		super(model, view);

	}
	
	//-------------------------Functionality-------------------------//
	
	@Override
	public void update(Observable o, Object arg) {

		String command = (String) arg;
		

		if ( o ==view ){
			
			switch (command) {
			case "start server":
				try {
					model.start();
					view.serverStartedEventHandler();
				} catch (Exception e) {
					view.displayInConsole("There was error while trying start server");
					view.serverStoppedEventHandler();
				}
				break;
			case "stop server":
				try {
					model.stop();
					view.serverStoppedEventHandler();
				} catch (Exception e) {
					view.displayInConsole("There was error while trying stop server. Please restart the server");
					view.displayMessage("There was error while trying stop server. Please restart the server");
					view.serverErrorEventHandler();
				}
				break;
			case "close server":
				
				break;
				
			case "disconnect client":
				model.disconnectClient((String) view.getCommandData(command));
				break;
			default:
				break;
			}
			
		}
		
		
		else if ( o == model )
		{
			Object commandData = model.getCommandData(command);
			
			switch (command) {
			case "add client":
				view.addClient(((String[])model.getCommandData(command)));
				break;

			case ("client input"):
				String[] clientFields = (String[]) commandData;
				view.updateClient(clientFields);
				break;
			case "console":
				view.displayInConsole((String) model.getCommandData(command));
				break;
				
			case "remove client":
				view.removeClient((String) model.getCommandData(command));
				
				break;
				
			case "server stopped":
				view.serverStoppedEventHandler();
				break;
				
				
			default:
				break;
			}
			
			
			
			/*if(command.equals("add client"))
				view.addClient(((String[])model.getCommandData(command)));
			
			if(command.equals("client input")){
				String[] clientFields = (String[]) commandData;
				view.updateClient(clientFields);
				
			}
			
			if(command.equals("console"))
				view.displayInConsole((String) model.getCommandData(command));
			
			if ( command.equals("remove client")){
				view.removeClient((String) model.getCommandData(command));
			}*/
		}

	}

}
