package view;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import haganaBk15.Link;
import haganaBk15.Snake;
import haganaBk15.SnakesBoard;
import maze.maze2d.Maze2D;
import position.position2d.Position2D;

public class SnakeWindow extends BasicWindow {
	
	SnakesBoard sb;
	Button run;
	Timer timer;
	TimerTask timerTask;
	
	
	public SnakeWindow(String title, int width, int height) {
		super(title, width, height);
		
	}

	@Override
	protected void initWidgets() {
		
		getShell().setLayout(new GridLayout(2, false));
		sb = new SnakesBoard(getShell(),  SWT.DOUBLE_BUFFERED, 30, 30);
		sb.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		run = new Button(getShell(), SWT.PUSH);
		run.setText("Run");
		run.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		run.setEnabled(true);
		Position2D end = new Position2D(sb.getExitCol(),sb.getExitRow());
		
		run.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Timer timer = new Timer();
				timerTask =new TimerTask() {
					
					@Override
					public void run() {
						Position2D start = new Position2D(sb.getCharacterCol(),sb.getCharacterRow());
						Maze2D maze = new Maze2D(30,30,start,end);
						maze.initMazeWithPass();
						for(Snake s :sb.getSnakes()){
							for( Link l : s.getLinks())
								maze.setValueByIndex(l.y, l.x, Maze2D.WALL);
								setChanged();
								notifyObservers(maze);
								
						}
						if ( sb.getCharacterRow() == sb.getExitRow() && sb.getCharacterCol() == sb.getExitCol())
							timer.cancel();
						
						
					}
				};
				
				timer.scheduleAtFixedRate(timerTask, 0, 100);
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	@Override
	public void displaySolution(ArrayList<Position2D> solution) {
		moveCharacter(solution);
		
	}
		
		
	private void moveCharacter(ArrayList<Position2D> movesSolution) {
		for (int i = 0; i < movesSolution.size()-1; i++) {		
			if((getMove(movesSolution.get(i), movesSolution.get(i+1)).equals("LEFT"))){
				sb.moveLeft();
			}
			else if((getMove(movesSolution.get(i), movesSolution.get(i+1)).equals("RIGHT"))){
				sb.moveRight();
			}
			else if((getMove(movesSolution.get(i), movesSolution.get(i+1)).equals("UP"))){
				sb.moveUp();
			}
			else if(getMove(movesSolution.get(i), movesSolution.get(i+1)).equals("DOWN")){
				sb.moveDown();
			}
		}
		//sb.moveDown();
	}
	
	private String getMove(Position2D pos1, Position2D pos2) {
		if (pos1.getX()== pos2.getX() - 1)
			return "RIGHT";
		else if (pos1.getX() == pos2.getX() + 1)
			return "LEFT";
		else if (pos1.getY() == pos2.getY() - 1)
			return "DOWN";
		else if (pos1.getY() == pos2.getY() + 1)
			return "UP";
		return null;	
	}
		
		

	@Override
	public void moveBackward() {
		sb.moveDown();

	}

	@Override
	public void moveLeft() {
		sb.moveLeft();

	}

	@Override
	public void moveRight() {
		sb.moveRight();

	}

	@Override
	public void moveForward() {
		sb.moveUp();

	}
	

}
