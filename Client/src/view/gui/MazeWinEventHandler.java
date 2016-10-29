package view.gui;


/**
 * <h1>MazeWinEventHandler</h1><p>
 * This interface is used for dependency injection of win event handlers
  * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 *
 */
public interface MazeWinEventHandler {

	/**
	 * <h1>winGame</h1><p>
	 * <i><ul>void winGame()<i><p>
	 * This method operates (however implemented) when the user solve the maze
	 */
	public void winGame();
}
