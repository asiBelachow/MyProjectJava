package view.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MyMessageBox {
	
	private MessageBox msgBox;
	
	
	


	public MyMessageBox(Shell shell, int style) {
		msgBox = new MessageBox(shell,style);
	}
	
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
	
	public MessageBox getMsgBox() {
		return msgBox;
	}

	public void setMsgBox(MessageBox msgBox) {
		this.msgBox = msgBox;
	}
}
