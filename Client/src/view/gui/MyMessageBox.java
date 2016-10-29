package view.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * <h1>MessageBox</h1><p>
 * This class wraps a MessageBox for  convenient use
 */
public class MyMessageBox {
	
	//------------------------------Data Members-------------------------//
	
	private MessageBox msgBox;

	//------------------------------Constructors-------------------------/
	
	/**
	 * <h1>MyMessageBox</h1><p>
	 * <i><ul>MyMessageBox(Shell shell, int style)<i><p>
	 * Initialize a new window.
	 * @param shell the shell
	 * @param style - style of the message box
	 */
	public MyMessageBox(Shell shell, int style) {
		msgBox = new MessageBox(shell,style);
	}
	
	//-----------------------------Setters and Getters-------------------//
	
		public MessageBox getMsgBox() {
			return msgBox;
		}

		public void setMsgBox(MessageBox msgBox) {
			this.msgBox = msgBox;
		}
	
	
		//-------------------------Functionality-------------------------//
	
	/**
	 * <h1>showMessage</h1><p>
	 * <i><ul>showMessage(Display display, String title, String msg)<i><p>.
	 * @param display - the display to show the message box
	 * @param title - title of the message ox
	 * @param msg - the message to show
	 */
	public void showMessage(Display display, String title, String msg) {

			display.syncExec(new Runnable() {

				@Override
				public void run() {
					msgBox.setText(title);
					msgBox.setMessage(msg);
					msgBox.open();
				}

			});
		}
	
	
}
