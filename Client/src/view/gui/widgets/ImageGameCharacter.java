package view.gui.widgets;


import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;



/**
 * <h1>ImageGameCharacter</h1><p>
 * Manage the game character image
 */
public class ImageGameCharacter extends GameCharacter {
	
	//------------------------------Data Members-------------------------//
	
	/** The image game charcter. */
	private Image image;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>ImageGameCharacter</h1><p>
	 * <i>ImageGameCharacter(Composite parent, int style, Image image)<i><p>
	 * Instantiates a new ImageGameCharacter.
	 * @param parent - Composite
	 * @param style - style
	 * @param image - image of the character
	 */
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

	//-----------------------------setters and getters-------------------//
	
	/**
	 * <h1>getImage</h1><p>
	 * <i><ul>Image getImage()<i><p>
	 * Get the image.
	 * @return image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * <h1>setImage</h1><p>
	 * <i><ul>void getImage()<i><p>
	 * Set the image.
	 * @param image - image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * <h1>paint</h1><p>
	 * <i><ul>void paint(PaintEvent e,int y,int x,int w, int h)<i><p>
	 * paint the image in given indexes.
	 * @param e the e
	 * @param y the y
	 * @param x the x
	 * @param w the w
	 * @param h the h
	 */
	public void paint(PaintEvent e,int y,int x,int w, int h){
		e.gc.drawImage(image, 0, 0, image.getBounds().width,image.getBounds().height,y, x, (int)Math.round(w*1.2), (int)Math.round(h*1.3));
	}

}

	
