package boot;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class ArrowButtonExample {
  Display d;

  Shell s;

   ArrowButtonExample() {
    d = new Display();
    s = new Shell(d);
    s.setSize(250, 250);
    
    s.setText("A Button Example");
    final Button b1 = new Button(s, SWT.ARROW | SWT.UP);
    b1.setBounds(50,50, 35, 40);
    final Button b2 = new Button(s, SWT.ARROW | SWT.DOWN);
    b2.setBounds(94, 100, 40, 35);

    final Button b3 = new Button(s, SWT.ARROW | SWT.LEFT);
    b3.setBounds(20, 20, 40, 35);
    
    s.open();
    while (!s.isDisposed()) {
      if (!d.readAndDispatch())
        d.sleep();
    }
    d.dispose();
  }

  public static void main(String[] argv) {
    new ArrowButtonExample();
  }

}