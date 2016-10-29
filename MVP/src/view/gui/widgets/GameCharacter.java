package view.gui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class GameCharacter extends Canvas {
	
	
	protected int z , x ,y ,w ,h;

	GameCharacter(Composite parent,int style) {
		super(parent,SWT.DOUBLE_BUFFERED);

	}
	
	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	

}
