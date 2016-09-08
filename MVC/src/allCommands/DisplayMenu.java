package allCommands;

import java.io.IOException;

import model.Model;

/**
 * <h1>Display Maze</h1><p>
 * This Class define the command to show a the menu</br>
 */
public class DisplayMenu extends ClientCommands {

	public DisplayMenu(Model m){
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommmand(String[] param) throws IOException {
		m.displayMenu();

	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
