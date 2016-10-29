package view.gui.widgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import maze.maze3d.*;
import position.position3d.*;



public class Maze3DDisplayer extends MazeDisplayer{

	protected Maze3D maze;
	protected Color black;
	protected ArrayList<Color> floorColors;
	protected boolean hintFlag;
	protected ToolTip toolTip;
	protected Tray tray;
	
	
	Timer timer;
	TimerTask timerTask;

	public Maze3DDisplayer(Composite parent, int style) {
		super(parent, style);
		this.maze = null;
		black = new Color(getDisplay(), 64, 64, 64);
		hintFlag =false;
	}
	
	public Maze3DDisplayer(Composite parent, int style,Maze3D maze) {
		super(parent, style);
		this.maze = maze;
		setBackgroundImage(new Image(getDisplay(), "resources/image/sonicbg.png"));
		character = new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/character_image.png"));
		winImage = new Image(getDisplay(), "resources/image/win_image.jpg");
		goalImage = new Image(getDisplay(), "resources/image/goal_image.png");
		//hintImage = new Image(getDisplay(), arg1)
		position = new Position3D();
		black = new Color(getDisplay(), 64, 64, 64);
		floorColors = initDistinctFloorColors(maze.getzAxis());
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				if(maze != null){
					e.gc.setAntialias(SWT.ON);
					int width = getSize().x;
					int height = getSize().y;

					int mx = width / 2;

					double w = (double) width / getMazeData().length ;
					double h = (double) height / getMazeData().length ;

					for (int i = 0; i <getMazeData().length ; i++) {
						
						double w0 = 0.5 * w + 0.4 * w * i / getMazeData().length;
						double w1 = 0.5 * w + 0.4 * w * (i + 1) / getMazeData().length;
						double start = mx - w0 *getMazeData()[i].length / 2;
						double start1 = mx - w1 * getMazeData()[i].length / 2;
						
						for (int j = 0; j < getMazeData()[i].length ; j++) {
							double[] dpoints = { start + j * w0, i * h, start + j * w0 + w0, i * h, start1 + j * w1 + w1,
									i * h + h, start1 + j * w1, i * h + h };
							double cheight = h / 2;

							if (getMazeData()[i][j] != 0)
								paintCube(dpoints, cheight, e);

							if (i == character.getX() && j== character.getY() )
								character.paint(e, (int) Math.round(dpoints[0]), (int) Math.round(dpoints[1] - cheight / 2),
										(int) Math.round((w0 + w1) / 2), (int) Math.round(h));

							if( i == maze.getEnd().getX() && j== maze.getEnd().getY() && maze.getEnd().getZ() == position.getZ())
								e.gc.drawImage(goalImage, 0, 0, goalImage.getBounds().width, goalImage.getBounds().height, (int) Math.round(dpoints[0]), (int) Math.round(dpoints[1] - cheight / 2), (int) Math.round((w0 + w1) / 2), (int) Math.round(h));

							
					          if(getMaze().checkPositionBounds(new Position3D(Position3D.MergePos(position, Position3D.UP)) ) &&  
					        		  getMaze().getValueByIndex(new Position3D(Position3D.MergePos(position, Position3D.UP)) )==0 &&( getMaze().getValueByIndex(position)==0)){	    
					        	
					          }
						}
					}
				}
				e.gc.setForeground(new Color(null, 255, 0, 0));
				e.gc.drawString("Position: " + position, 20, 20);
			}
		});
	}
	
	public Image getWinImage() {
		return winImage;
	}
	
	public void setWinImage(Image winImage) {
		this.winImage = winImage;
	}

	public Maze3D getMaze() {
		return maze;
	}
	
	public boolean isHintFlag() {
		return hintFlag;
	}

	public void setHintFlag(boolean hintFlag) {
		this.hintFlag = hintFlag;
		redraw();
	}

	public void setMaze(Maze3D maze) {
		this.maze = maze;
		addListeners();
	}
	
	public void addListeners(){
		floorColors = initDistinctFloorColors(maze.getzAxis());
		
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				if(maze != null){
					
					e.gc.setAntialias(SWT.ON);
					int width = getSize().x;
					int height = getSize().y;

					int mx = width / 2;

					double w = (double) width / getMazeData().length ;
					double h = (double) height / getMazeData().length ;

					e.gc.drawImage(getBackgroundImage(), 0, 0,getBackgroundImage().getBounds().width,getBackgroundImage().getBounds().height,0,0,width,height);
					
					for (int i = 0; i <getMazeData().length ; i++) {


						double w0 = 0.5 * w + 0.4 * w * i / getMazeData().length;
						double w1 = 0.5 * w + 0.4 * w * (i + 1) / getMazeData().length;
						double start = mx - w0 *getMazeData()[i].length / 2;
						double start1 = mx - w1 * getMazeData()[i].length / 2;
						
						for (int j = 0; j < getMazeData()[i].length ; j++) {
							double[] dpoints = { start + j * w0, i * h, start + j * w0 + w0, i * h, start1 + j * w1 + w1,
									i * h + h, start1 + j * w1, i * h + h };
							double cheight = h / 2;

							if (getMazeData()[i][j] != 0)
								paintCube(dpoints, cheight, e);

							
							if (i == character.getX() && j== character.getY() )
								character.paint(e, (int) Math.round(dpoints[0]), (int) Math.round(dpoints[1] - cheight / 2),
										(int) Math.round((w0 + w1) / 2), (int) Math.round(h));
						

							if( i == maze.getEnd().getX() && j== maze.getEnd().getY() && maze.getEnd().getZ() == position.getZ())
								e.gc.drawImage(goalImage, 0, 0, 254, 380, (int) Math.round(dpoints[0]), (int) Math.round(dpoints[1] - cheight / 2), (int) Math.round((w0 + w1) / 2), (int) Math.round(h));
							
						
							
							/*  Position3D floor = new Position3D(position.getZ(), i, j);
					          if(maze.checkPositionBoundsNoException(Position3D.MergePos(position, Position3D.UP))==true && maze.getValueByIndex(position.getZ(), i, j) == 0 && (i==position.getX()) && (j==position.getY()) ){
						 			e.gc.drawImage(goalImage, 0, 0, goalImage.getBounds().width, goalImage.getBounds().height, (int) Math.round(dpoints[0]), (int) Math.round(dpoints[1] - cheight / 2), (int) Math.round((w0 + w1) / 2), (int) Math.round(h));
								}*/
					          
					          /*if(getMaze().checkPositionBounds(new Position3D(Position3D.MergePos(position, Position3D.UP)) ) &&  
					        		  getMaze().getValueByIndex(new Position3D(Position3D.MergePos(position, Position3D.UP)) )==0 ){
					        	  paintCube(dpoints, cheight, e);
					        	  
					          }*/
						}
					}
				}
				if(hintFlag == true){
					e.gc.setBackground(new Color(null, 255,255,255));
					e.gc.setForeground(new Color(null, 0, 0,0));
					e.gc.drawString("Goal Position at floor: " + maze.getEnd().getZ(), 20, 40);
				}
				e.gc.setForeground(new Color(null, 255, 0, 0));
				e.gc.drawString("Position: " + position, 20, 20);

			}
		});

		addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				if (black !=  null && !black.isDisposed())
					black.dispose();
				if(character !=null && !character.isDisposed())
					character.dispose();
				if ( winImage != null && !winImage.isDisposed() )
					winImage.dispose();
				if ( goalImage != null && !goalImage.isDisposed() )
					goalImage.dispose();
				if ( hintImage != null && !hintImage.isDisposed() )
					hintImage.dispose();
				backgrounds.clear();
			}
		});
		
	}
	
	@Override
	public void setCharacterPosition(Position3D p) {
		character.setZ(p.getZ());
		character.setX(p.getX());
		character.setY(p.getY());
		position = new Position3D(p);
		setMazeData(getMaze().getCrossSectionByZ(position.getZ()));
		System.out.println(p);
		redraw();
		//moveCharacter(p);
	}

	public Position3D getPosition() {
		return position;
	}

	public void setPosition(Position3D position) {
		this.position = position;
	}

	

	@Override
	public void moveCharacter(Position3D p) {
		// if at end position
		if (getMaze().getEnd().equals(p)) {
			//redraw();
			triggerWin();
			//dispose();
		}

		else if ( getMaze().checkPositionBoundsNoException(p) && getMaze().getValueByIndex(p) ==0){
			setCharacterPosition(p);
			setNumofSteps(getNumofSteps()+1);
			
		}
		;
	}

	@Override
	public void moveUp() {
		Position3D newPos = new Position3D(position);
		newPos.setZ(newPos.getZ() + 1);
		 moveCharacter(newPos);
	}

	@Override
	public void moveDown() {
		Position3D newPos = new Position3D(position);
		newPos.setZ(newPos.getZ() - 1);
		moveCharacter(newPos);
	}

	@Override
	public void moveLeft() {
		Position3D newPos = new Position3D(position);
		newPos.setY(newPos.getY() - 1);
		moveCharacter(newPos);
	}

	@Override
	public void moveRight() {
		Position3D newPos = new Position3D(position);
		newPos.setY(newPos.getY() + 1);
		moveCharacter(newPos);
	}

	@Override
	public void moveFront() {
		Position3D newPos = new Position3D(position);
		newPos.setX(newPos.getX() + 1);
		moveCharacter(newPos);
	}

	@Override
	public void moveBack() {
		Position3D newPos = new Position3D(position);
		newPos.setX(newPos.getX() - 1);
		moveCharacter(newPos);
	}

	
	private ArrayList<Color> initDistinctFloorColors(int numOfFloors) {
		ArrayList<Color> colors = new ArrayList<Color>();

		Random rnd = new Random();
		for (int i = 0; i < numOfFloors; i++)
			colors.add(new Color(getDisplay(), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));

		return colors;
	}
	
	@Override
	public void showSoution(ArrayList<Position3D> sol) {
		getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				timer = new Timer();
				
				Iterator<Position3D> iter = sol.iterator();
				
				timer.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						if(iter.hasNext()){
							getDisplay().syncExec(new Runnable() {
								
								@Override
								public void run() {	
									moveCharacter(iter.next());
								}
							});
						}else{
							
							if(timer!=null)
								timer.cancel();
						}
					}
				}, 0, 100);
			}
		});
	}
	

	public void paintCube(double[] p, double h, PaintEvent e) {
		int[] f = new int[p.length];
		for (int k = 0; k < f.length; f[k] = (int) Math.round(p[k]), k++);

		int[] r = f.clone();
		for (int k = 1; k < r.length; r[k] = f[k] - (int) (h), k += 2);

		int[] fr = { r[6], r[7], r[4], r[5], f[4], f[5], f[6], f[7] };
		int[] right = { r[2], r[3], f[2], f[3], f[4], f[5], r[4], r[5] };
		int[] left = { r[0], r[1], f[0], f[1], f[6], f[7], r[6], r[7] };
		e.gc.setLineWidth(SWT.NONE);

			
		e.gc.setBackground(floorColors.get(position.getZ()));
		e.gc.drawPolygon(right);
		e.gc.drawPolygon(left);
		e.gc.drawPolygon(fr);
	
		e.gc.setBackground(black);
		e.gc.drawPolygon(right);
		e.gc.fillPolygon(right);
		e.gc.drawPolygon(fr);
		e.gc.fillPolygon(fr);
		e.gc.setBackground(floorColors.get(position.getZ()));
		e.gc.fillPolygon(r);
		e.gc.setBackground(floorColors.get(position.getZ()));
		e.gc.drawPolygon(r);

	}

	


}
