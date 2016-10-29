package view.gui.widgets;

import java.util.ArrayList;
import org.eclipse.swt.widgets.Composite;
import position.position2d.*;
import position.position3d.*;

//For maze2D

/**
 * <h1>Maze2DDisplayer</h1><p>
 * This class extends {@link MazeDisplayer} class and its handle the drawing the maze 2d and the character image
 * 
 */
public class Maze2DDisplayer extends MazeDisplayer {

	public Maze2DDisplayer(Composite parent, int style) {
		super(parent, style);
	
	}

	@Override
	public void moveUp() {
		
		
	}

	@Override
	public void moveDown() {
		
		
	}

	@Override
	public void moveLeft() {
		
		
	}

	@Override
	public void moveRight() {
	
		
	}

	@Override
	public void moveFront() {
		
	
	}

	@Override
	public void moveBack() {
		
		
	}


	public void setCharacterPosition(Position2D p) {
		// TODO Auto-generated method stub

	}


	public boolean moveCharacter(Position2D p) {
		// TODO Auto-generated method stub
		return false;
	}


	public void showSoution1(ArrayList<Position2D> sol) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterPosition(Position3D p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveCharacter(Position3D p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showSoution(ArrayList<Position3D> sol) {
		// TODO Auto-generated method stub
		
	}
	

}
