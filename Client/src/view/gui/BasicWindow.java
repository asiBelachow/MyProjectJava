package view.gui;



import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * <h1>BasicWindow</h1><p>
 * This class is the main window of the Graphic User Interface<br>
 */
public abstract class BasicWindow extends ObservableCommonGUIView implements Runnable{
	
	//------------------------------Data Members-------------------------//

	protected Display display;
	protected Shell shell;
	
	//------------------------------Constructors-------------------------//
	
	
	/**
	 * <h1>Basic Window </h1><p>
	 * <i><ul>BasicWindow(String title, int width, int height)<i><p>
	 * Initialize a new window.
	 *
	 * @param title - Title of the windows
	 * @param width - Width of the windows
	 * @param height - Height of the window
	 */
	public BasicWindow(String title, int width, int height) {
		
		display = new Display();
		shell = new Shell(display);
		shell.setSize(width, height);
		shell.setText(title);
	}
	
	
	/**
	 * <h1>Get Display</h1><p>
	 * <i><ul>Display getDisplay() <i><p>
	 * Get the data member display.
	 * @return the display
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * <h1>Set Display</h1><p>
	 * <i><ul>void setDisplay(Display display)<i><p>
	 * Set the data member display.
	 */
	public void setDisplay(Display display) {
		this.display = display;
	}

	/**
	 * <h1>Get Shell</h1><p>
	 * <i><ul>Display getShell() <i><p>
	 * Get the data member shell.
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * <h1>Set Shell</h1><p>
	 * <i><ul>void setDisplay(Display display)<i><p>
	 * Set the data member shell.
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}
	

	/**
	 * <h1>init Widgets</h1><p>
	 * <i><ul>void initWidgets()<i><p>
	 * Initialize all the widgets in the main window
	 */
	protected abstract void initWidgets();
	
	@Override
	public void run() {
		initWidgets();
		shell.open();

		while(!shell.isDisposed()){ 
			if(!display.readAndDispatch()){ 	
				display.sleep(); 			
			}
		} 

		display.dispose();
	}



	
	
}
