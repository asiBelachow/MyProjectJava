package allCommands;

import model.Model;


/**
 * <h1>Solve Maze</h1><p>
 * This Class define the command to solve a Maze3D</br>
 */
public class SolveMaze extends ClientCommands {

	public SolveMaze(Model m) {
		super(m);
	}

	@Override
	public void doCommmand(String[] param) {
		m.solveMaze(param[1], param[2]);
		
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}


}
