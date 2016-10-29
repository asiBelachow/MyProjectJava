package view.gui.widgets;


import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class ImageGameCharacter extends GameCharacter {
	
	private Image image;
	
	
	
	public ImageGameCharacter(Composite parent, int style, Image image) {
		super(parent, style);
		
		this.image =image;
		
		addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				if( image!=null && !image.isDisposed())
					image.dispose();
			}
		});
		
	}

	
	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}



	
	public void paint(PaintEvent e,int y,int x,int w, int h){

		e.gc.drawImage(image, 0, 0, image.getBounds().width,image.getBounds().height,y, x, (int)Math.round(w*1.2), (int)Math.round(h*1.3));


	}


	
	
	
}

	
