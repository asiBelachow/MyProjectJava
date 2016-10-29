package presenter;

import java.io.Serializable;



/**
 * The Class Properties.
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-09-17
 */
public class Properties implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3958798948682138687L;

	
	private String title;
	private Integer width;
	private Integer height;
	private String searchAlg;
	private String serverIp;
	private Integer serverPort;
	private Boolean sound;
	
	
	
	public Properties() {
		
		this.title = "Enter windows name";
		this.width = 800;
		this.height = 600;
		this.searchAlg = "BFS";
		this.serverPort = 5555;
		this.serverIp = "127.0.0.1";
		this.sound = true;
	}
	
	public Properties(String title,Integer width,Integer height,String searchAlg,String serverIp,Integer serverPort,Boolean sound) {
	
		this.setTitle(title);
		this.setWidth(width);
		this.setHeight(height);
		this.setSearchAlg(searchAlg);
		this.setServerIp(serverIp);
		this.setServerPort(serverPort);
		this.setSound(sound);
		
	}
	public String getSearchAlg() {
		return searchAlg;
	}

	public void setSearchAlg(String searchAlg) {
		this.searchAlg = searchAlg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Boolean getSound() {
		return sound;
	}

	public void setSound(Boolean sound) {
		this.sound = sound;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}



	
	
	
	
	
	

}
