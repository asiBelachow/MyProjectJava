package allCommands;

import java.io.IOException;

import model.Model;

/**
 * <h1>Save Maze</h1><p>
 * This Class define the command to save a Maze3D</br>
 * to a file 
 */
public class SaveMaze extends ClientCommands {

	public SaveMaze(Model m) {
		super(m);

	}

	@Override
	public void doCommmand(String[] param) throws IOException {

		m.saveMaze(param[1], param[2]);
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}

	

}
