package view.widgets;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;

import algorithms.maze3DGenerators.Position;

public class Maze2DWidget extends MazeDisplayer {

	public Maze2DWidget(Composite parent, int style) {
		super(parent, style);
	
	}

	@Override
	public boolean moveUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveFront() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveBack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCharacterPosition(Position p) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean moveCharacter(Position p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showSoution(ArrayList<Position> sol) {
		// TODO Auto-generated method stub

	}

}
