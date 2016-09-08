package allCommands;

import model.Model;




/**
 * <h1>Display CrossSection By Dimension</h1><p>
 * This Class define the command to show a</br>
 * section of the maze by dimension and index
 * files and folder in given directory<p>
 */
public class DisplayCrossSectionByDimension extends ClientCommands {

	public DisplayCrossSectionByDimension(Model m) {
		super(m);
		
	}
	
	
	@Override
	public void doCommmand(String[] param) {
		
		m.CrossSectionByDimention(Integer.parseInt(param[3]), param[4], param[5]);

	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}


}
