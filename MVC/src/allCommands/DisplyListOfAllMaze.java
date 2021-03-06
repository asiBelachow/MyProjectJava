package allCommands;

import java.io.IOException;

import model.Model;

public class DisplyListOfAllMaze extends ClientCommands {

	/**
	 * <h1>Display Solution</h1><p>
	 * This Class define the command to show all</br>
	 * the mazes that generated
	 */
	public DisplyListOfAllMaze(Model m) {
		super(m);
	}

	@Override
	public void doCommmand(String[] param) throws IOException {
		
		m.displayListOfAllMaze();

	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}


}
