package allCommands;

import java.io.IOException;

import model.Model;

/**
 * <h1>The Class DirPath</h1><p>
 * This Class define the command to close the appliction</br>
 */
public class Close extends ClientCommands {

	public Close(Model m) {
		super(m);
	}

	@Override
	public void doCommmand(String[] param) throws IOException {
		m.close();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
