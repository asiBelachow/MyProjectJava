package maze.maze2d;

import java.util.ArrayList;

import position.position2d.Position2D;


/**
 * The Class Maze2D defines the representation of two-dimensional maze
 * Hold xAxis yAxis dimensions</br>
 * xAxis - represent the rows</br>
 * yAxis - represent the columns</br>
 * The 2D maze represent by two dimensional array of integer: int[xAxis][yAxis]
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class Maze2D extends AbstractMaze2D {

	//------------------------------Data Members-------------------------//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7515685569576166374L;

	private int xAxis;
	
	private int yAxis;
	
	private Position2D start;
	
	private Position2D end;
	
	private int array[][];
	
	//-----------------------------setters and getters-------------------//
	
	
	public Maze2D() {
		
		setxAxis(0);
		setyAxis(0);
		setStart(null);
		setEnd(null);
	}
	
	public Maze2D(int xAxis, int yAxis) {

		array = new int[xAxis][yAxis];
		setxAxis(xAxis);
		setyAxis(yAxis);
		setStart(null);
		setEnd(null);
	}

	
	public Maze2D(Maze2D maze) {

		
		setxAxis(maze.getxAxis());
		setyAxis(maze.getyAxis());
		setStart(new Position2D(maze.getStart()));
		setEnd(new Position2D(maze.getEnd()));
		for(int i =0 ;i<xAxis;i++)
			for (int j=0 ;j<yAxis;j++)
				array[i][j] = maze.getValueByIndex(i, j);
	}
	
	public Maze2D(int xAxis,int yAxis ,Position2D start,Position2D end) {

		array = new int[xAxis][yAxis];
		setxAxis(xAxis);
		setyAxis(yAxis);
		setStart(new Position2D(start));
		setEnd(new Position2D(end));
		
	}
	
	
	//-----------------------------setters and getters-------------------//
	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	@Override
	public Position2D getStart() {
		return start;
	}

	public void setStart(Position2D start) {
		this.start = start;
	}

	@Override
	public Position2D getEnd() {
		return end;
	}

	public void setEnd(Position2D end) {
		this.end = end;
	}

	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}



	
	
	//-------------------------Functionality-------------------------//
	
	@Override
	public boolean equals(Object arg) {
		Maze2D maze = (Maze2D) arg;
		if (getxAxis() == maze.getxAxis() && getyAxis() == maze.getyAxis()) {
			if (getStart().equals(maze.getStart()) && getEnd().equals(maze.getEnd())) {

				for (int j = 0; j < this.array.length; j++) {
					for (int j2 = 0; j2 < this.array[0].length; j2++) {
						if (this.array[j][j2] != maze.getValueByIndex(j, j2)) {
							return false;
						}
					}
				}
			}
		} 

		return true;
	}

	@Override
	public String toString() {
		StringBuilder printMaze= new StringBuilder ();
		for(int x=0; x < getxAxis(); x++){
			for(int y=0; y < getyAxis(); y++){
				printMaze.append(array[x][y]+ "   ");
			}
			printMaze.append("\n");
		}
		return printMaze.toString();
	}
	
	
	
	@Override
	public boolean checkPositionBounds(int x, int y) {
		return ((x>=0 && x<=getxAxis() && (y>=0 && y<getyAxis())));
	}

	@Override
	public boolean checkPositionBounds(Position2D p) {
		return checkPositionBounds(p.getX(), p.getY());
	
	}
	
	@Override
	public int getValueByIndex(int x, int y) {
		if (checkPositionBounds(x, y))
			return array[x][y];
		else
			throw new IndexOutOfBoundsException(" Position out of bound {"+x +","+y+"}");
	}

	@Override
	public int getValueByIndex(Position2D p) {
		return array[p.getX()][p.getY()];
	}
	
	public boolean checkPositionBoundsNoException(Position2D p) {
		return ((p.getX() >= 0 &&p.getX()<getxAxis())&&(p.getY()>=0&&p.getY()<getyAxis()));

	}

	
	public void setValueByIndex(int x, int y,int value){
		if(checkPositionBounds(x, y))
			array[x][y]=value;
		else
			throw new IndexOutOfBoundsException(" Position out of bound {"+x +","+y+"}");
	}
	
	public void setValueByIndex(Position2D p,int value){
		if(checkPositionBounds(p))
			array[p.getX()][p.getX()]=value;
		else
			throw new IndexOutOfBoundsException(" Position out of bound {"+p.getX() +","+p.getX()+"}");
	}
	
	

	public void initMazeWithPass(){
		for (int i=0 ; i< getxAxis(); i++)
			for (int j=0 ; j< getyAxis();j++){
				setValueByIndex(i, j, PASS);
			}
				
	}
	
	@Override
	public ArrayList<Position2D> getPossibleMoves(Position2D pos) {
		ArrayList<Position2D> pMoves = new ArrayList<Position2D>();		
		Position2D temp = Position2D.MergePos(pos, Position2D.RIGHT);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position2D.MergePos(pos, Position2D.LEFT);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position2D.MergePos(pos, Position2D.BACKWARD);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position2D.MergePos(pos, Position2D.FORWARD);
		if(checkPositionBoundsNoException(temp)){
			if(getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		
		return pMoves;

	}






}
