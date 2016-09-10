package allCommands;

import java.io.IOException;

import model.Model;


/**
 * <h1>Load Maze</h1><p>
 * This Class define the command to load a Maze3D</br>
 * that saved to file by the name of the file
 */
public class LoadMaze extends ClientCommands {

	public LoadMaze(Model m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommmand(String[] param) throws IOException {
		m.loadMaze(param[1], param[2]);

	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}


}
