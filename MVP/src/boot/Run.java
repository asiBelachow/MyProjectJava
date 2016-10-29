package boot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import model.MyModel;
import presenter.MyPresenter;
import presenter.Properties;
import presenter.PropertiesHandler;
import view.cli.CLI;
import view.cli.ObservableCLIView;
import view.gui.GameWindow;



public class Run {

	public static void main(String[] args) {
		initStart();

	}
	
	private static void initStart(){
		Display display  = new Display();
		Shell shell = new Shell(display);
		Properties prop=null;
		MyModel model = new MyModel();;
		CLI client = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out,true));;
		MyPresenter presenter = null;
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO  );
		messageBox.setText("GUI/CLI");
		messageBox.setMessage("Start The program with GUI/CLI?\nFor GUI press Yes.\nFor CLI press No.");
		int buttonID = messageBox.open();
		switch (buttonID) {
		case SWT.YES:
			shell.dispose();
			display.dispose();
			try{
				prop = PropertiesHandler.getInstance();
			}catch (FileNotFoundException e) {
				prop = new Properties();
			}
			GameWindow guiView =  new GameWindow(prop);
			presenter = new MyPresenter(model, guiView);
			guiView.addObserver(presenter);
			model.addObserver(presenter);
			guiView.run();
			
			break;
		case SWT.NO:
			shell.dispose();
			display.dispose();
			ObservableCLIView cliView=  new ObservableCLIView(client);
			presenter = new MyPresenter(model, cliView);
			client.addObserver(cliView);
			cliView.addObserver(presenter);
			model.addObserver(presenter);
			cliView.run();
			break;
			/*	default:
				shell.dispose();
				display.dispose();
				break;*/
		}


		//System.out.println(buttonID);
	}


}
	
	
	


