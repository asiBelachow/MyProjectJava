package boot;

import java.io.FileNotFoundException;

import model.MyServer;
import model.ServerModel;
import presenter.MyPresenter;
import presenter.Properties;
import presenter.PropertiesHandler;
import view.gui.ServerGui;

public class Run {

	public static void main(String[] args) {
		
		Properties prop=null;
		try{
			prop = PropertiesHandler.getInstance();
		}catch (FileNotFoundException e) {
			prop = new Properties();
		}
		
		ServerGui view = new ServerGui(prop);
		ServerModel model = new MyServer();
		MyPresenter presenter = new MyPresenter(model,view);
		view.addObserver(presenter);
		((MyServer) model).addObserver(presenter);
		view.start();
		
		
		
		
		
	}
	
	

}
