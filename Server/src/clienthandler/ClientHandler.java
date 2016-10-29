package clienthandler;


/**<h1>ClientHandler</h1>
 * An interface used for dependency injection of how to handle clients 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-10-17
 */
public interface ClientHandler {
	
	
	/**
	 * <h1>handleClient()</h1><p>
	 * <i><ul>void handleClient()<i><p>
	 * Handle the request of the connected client
	 */
	public void handleClient();
	
	
	/**
	 * <h1>handleGenerateMaze</h1><p>
	 * <i><ul>void handleGenerateMaze(String name,int z,int x,int y)<i><p>
	 * Handle the request of generating maze from the client.
	 * @param name - the name of the maze
	 * @param z - zAxis dimension
	 * @param x - xAxis dimension
	 * @param y - yAxis dimension
	 */
	public void handleGenerateMaze(String name,int z,int x,int y);

	
	/**
	 * <h1>handleSolveMaze</h1><p>
	 * <i><ul>void handleSolveMaze(String name,String algorithm)<i><p>
	 * Handle the request of solve maze from the client.
	 * @param name - the name of the maze to solve
	 * @param algorithm - the algorithm to solve the maze
	 */
	public void handleSolveMaze(String name,String algorithm);
	
	/**
	 * <h1>handleDisplayMaze</h1><p>
	 * <i><ul>void handleDisplayMaze(String name)<i><p>
	 * Handle the request of display maze from the client.
	 * @param name - the name of the maze to display
	 */
	public void handleDisplayMaze(String name);
	
	/**
	 * <h1>handleDisplaySolution</h1><p>
	 * <i><ul>void handleDisplaySolution(String name)<i><p>
	 * Handle the request of display solution of a maze from the client.
	 * @param name - the name of the maze
	 */
	public void handleDisplaySolution(String name);
	
	/**
	 * <h1>handleDisconnect</h1><p>
	 * <i><ul>void handleDisconnect(String clientId)<i><p>
	 * Handle the request of disconnecting from the client.
	 * @param clientId - the id of the client
	 */
	public void handleDisconnect(String clientId);
	
	/**
	 * <h1>handleDisplayCrossSectionByDimention</h1><p>
	 * <i><ul>void handleDisplayCrossSectionByDimention(int index,String dimention,String name)<i><p>
	 * Handle the request of display a cross section of a maze from the client.
	 * @param index - the index of the maze
	 * @param dimention - the dimension of the maze
	 * @param name - the name of the maze
	 */
	public void handleDisplayCrossSectionByDimention(int index,String dimention,String name);
	
	
	

}
