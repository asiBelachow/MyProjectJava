package presenter;

import java.io.Serializable;

/**
 * A simple properties class to represent our XML properties in object oriented
 * way
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-10-06
 *
 */
public class Properties implements Serializable {
	
	//-------------------------Data Members-------------------------//
	
	private static final long serialVersionUID = -807356610719278540L;
	
	private String title;
	private Integer width;
	private Integer height;
	private String mazeGenerator;
	private String solveAlgorithm;
	private Integer numOfAllowedClients;
	private Integer maxNumOfThreads;
	private Integer serverPort;
	
	//------------------------------Constructors-------------------------//
	
	public Properties() {
		
		title = "Admin Window";
		width = 800;
		height = 600;
		mazeGenerator = "GrowingTreeMazeGenerator";
		solveAlgorithm = "AstarAD";
		numOfAllowedClients = 5;
		maxNumOfThreads = 3;
		serverPort = 5000;
	}	
	
	public Properties(String title, Integer width, Integer height,String mazeGenerator, String solveAlgorithm
			,Integer numOfAllowedClients,Integer maxNumOfThreads,Integer servePort){

		setTitle(title);
		setWidth(width);
		setHeight(height);
		setMazeGenerator(mazeGenerator);
		setSolveAlgorithm(solveAlgorithm);
		setServerPort(servePort);
		setNumOfAllowedClients(numOfAllowedClients);
		setMaxNumOfThreads(maxNumOfThreads);	
	}

	//-----------------------------Setters and Getters-------------------//
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public Integer getNumOfAllowedClients() {
		return numOfAllowedClients;
	}

	public void setNumOfAllowedClients(Integer numOfAllowedClients) {
		this.numOfAllowedClients = numOfAllowedClients;
	}

	public String getMazeGenerator() {
		return mazeGenerator;
	}

	public void setMazeGenerator(String mazeGenerator) {
		this.mazeGenerator = mazeGenerator;
	}

	public String getSolveAlgorithm() {
		return solveAlgorithm;
	}

	public void setSolveAlgorithm(String solveAlgorithm) {
		this.solveAlgorithm = solveAlgorithm;
	}

	public Integer getMaxNumOfThreads() {
		return maxNumOfThreads;
	}

	public void setMaxNumOfThreads(Integer maxNumOfThreads) {
		this.maxNumOfThreads = maxNumOfThreads;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}



}
