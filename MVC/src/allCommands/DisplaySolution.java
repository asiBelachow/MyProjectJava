package allCommands;

import model.Model;


/**
 * <h1>Display Solution</h1><p>
 * This Class define the command to show a</br>
 * solution of a given maze
 */
public class DisplaySolution extends ClientCommands {


	public DisplaySolution(Model m) {
		super(m);

	}

	@Override
	public void doCommmand(String[] param) {
		m.displaySolution(param[1]);
	}

	@Override
	public String toString() {
		return getClass().getName();
	}


}
