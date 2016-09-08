package allCommands;

import model.Model;



/**
 * <h1>The Class DirPath</h1><p>
 * This Class define the command to show list of</br>
 * files and folder in given directory<p>
 */
public class DirPath extends ClientCommands {

	
	public DirPath(Model m) {
		super(m);
		
	}
	
	
	@Override
	public void doCommmand(String[] param) {
		String path = param[1];
		m.dirPath(path);

	}
	
	
	@Override
	public String toString() {
		return getClass().getName();
	}

}
