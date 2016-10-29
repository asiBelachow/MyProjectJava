package maze.maze3d;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import position.position3d.Position3D;



/**
 * The Class Maze3d defines the representation of three-dimensional maze
 * Hold zAxis, xAxis, yAxis dimensions</br>
 * zAxis - represent the floors</br>
 * xAxis - represent the rows</br>
 * yAxis - represent the columns</br>
 * The 3D maze represent by three dimensional array of integer: int[zAxis][xAxis][yAxis]
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class Maze3D extends AbstractMaze3D  {
	
	//------------------------------Data Members-------------------------//
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2449909436689543232L;

	/*The Constant CASING - define the casing of the maze*/
	public static final int CASING = 2;
	
	/*The z axis - represent the floors*/
	private int zAxis;   
	
	/*The x axis - represent the rows*/
	private int xAxis;
	
	/*The y axis - represent the columns*/
	private int yAxis;
	
	/*Three dimensional array of integer - represent the 3d maze*/
	private int [][][] array;
	
	/*The maze entrance {@link Position} */
	private Position3D start;
	
	/*The maze exit. {@link Position} */
	private Position3D end;
	
	private String mazeName = null;

	


	Random r;
	
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 *<h1>Maze3D</h1><p>
	 * <i><ul>Maze3D()<i><p>
	 * Initialize a new 3D maze - default CTOR
	 */
	public Maze3D() {
		
	}
	
	/**
	 *<h1>Maze3D</h1><p>
	 * <i><ul>Maze3D(int z , int x , int y)<i><p>
	 * Initialize a new 3D maze
	 *
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 */
	public Maze3D(int z , int x , int y) {
		setzAxis(z*2+1);
		setxAxis(x*2+1);
		setyAxis(y*2+1);
		array = new int[getzAxis()][getxAxis()][getyAxis()];
		start = null;
		end = null;
		mazeName = null;
	}
	
	/**
	 * <h1>Maze3D</h1><p>
	 * <i><ul>Maze3D(int z , int x , int y)<i><p>
	 * Initialize a new 3D maze.
	 *
	 * @param mazeName -  the name of the maze 
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 */
	public Maze3D(String mazeName ,int z , int x , int y) {
		setzAxis(z*2+1);
		setxAxis(x*2+1);
		setyAxis(y*2+1);
		array = new int[getzAxis()][getxAxis()][getyAxis()];
		start = null;
		end = null;
		this.mazeName = mazeName;
	}
	
	/**
	 *<h1>Maze3D</h1><p>
	 * <i> <ul>Maze3D(Maze3D maze)<i><p>
	 * Copy Constructor of 3d maze
	 */
	public Maze3D(Maze3D maze){
		setzAxis(maze.getzAxis());
		setxAxis(maze.getxAxis());
		setyAxis(maze.getyAxis());
		setStart(new Position3D(maze.getStart()));
		setEnd(new Position3D(maze.getEnd()));
		array = new int[getzAxis()][getxAxis()][getyAxis()];
		setArray(maze.getArray());
		setMazeName(maze.getMazeName());
	
	}
	
	
	/**
	 * <h1>Maze3D</h1><p>
	 * <i><ul>Maze3D(int zAxis, int xAxis, int yAxis , Position3D start,Position3D end )<i><p>
	 * Initialize a new 3D maze.
	 * @param zAxis the z axis
	 * @param xAxis the x axis
	 * @param yAxis the y axis
	 * @param start - the start position
	 * @param end - the end position
	 */
	public Maze3D(int zAxis, int xAxis, int yAxis , Position3D start,Position3D end ){
		setzAxis(zAxis*2+1);
		setxAxis(xAxis*2+1);
		setyAxis(yAxis*2+1);
		setStart(new Position3D(start));
		setEnd(new Position3D(end));
		array = new int[getzAxis()][getxAxis()][getyAxis()];
	
	}
	

	
	
	/**
	 *<h1>Maze3D</h1><p>
 	 * <i> <ul>Maze3D(byte[] array)<i><p>
	 * Initialize a new 3D maze from a given byte array
	 */
	public Maze3D(byte[] array) throws IOException {
		
		ByteArrayInputStream bIn= new ByteArrayInputStream(array);
		DataInputStream data = new DataInputStream(bIn);
		int length = data.readInt();
		byte[] b = new byte[length];
		data.read(b, 0,length);
		String s = new String(b);
		this.setMazeName(s);
		this.setzAxis(data.readInt());
		this.setxAxis(data.readInt());
		this.setyAxis(data.readInt());
		this.setStart(new Position3D(data.readInt(), data.readInt(), data.readInt()));
		this.setEnd(new Position3D(data.readInt(), data.readInt(), data.readInt()));
		this.array = new int[getzAxis()][getxAxis()][getyAxis()];
		
		for (int i=0;i<getzAxis();i++)
			for(int j=0;j<getxAxis();j++)
				for(int k=0;k<getyAxis();k++)
					this.array[i][j][k]=data.readByte();
	}
	
	
	//-----------------------------setters and getters-------------------//
	
	public int getzAxis() {
		return zAxis;
	}

	public void setzAxis(int zAxis) {
		this.zAxis = zAxis;
	}

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

	public int[][][] getArray() {
		return array;
	}

	public void setArray(int[][][] array) {
		int z = array.length;
		int x = array[0].length;
		int y = array[0][0].length;
		this.array = new int[z][x][y];
		for (int i=0;i<z;i++)
			for(int j=0;j<x;j++)
				for(int k=0;k<y;k++)
					this.array[i][j][k]=array[i][j][k];
	}

	public Position3D getStart() {
		return start;
	}

	public void setStart(Position3D start) {
		this.start = start;
	}
	

	public Position3D getEnd() {
		return end;
	}

	public void setEnd(Position3D end) {
		this.end = end;
	}
	
	public String getMazeName() {
		return mazeName;
	}

	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}
	
	
	//-------------------------Functionality-------------------------//

	
	
	/**
	 *<h1>toByteArray</h1><p>
	 * <i><ul>byte[] toByteArray()<i><p>
	 *
	 *This method convert the Maze3D to a ByteArray
	 *@see maze.maze3d.Maze3D @link #Maze3D(Maze3D)
	 * @return ByteArray - the converted Maze3D
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public byte[] toByteArray() throws IOException{
		
		ByteArrayOutputStream array = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(array);
		
		data.writeInt(getMazeName().length());
		byte[] b = getMazeName().getBytes();
		data.write(b);
		data.writeInt(getzAxis());
		data.writeInt(getxAxis());
		data.writeInt(getyAxis());
		data.writeInt(getStart().getZ());
		data.writeInt(getStart().getX());
		data.writeInt(getStart().getY());
		data.writeInt(getEnd().getZ());
		data.writeInt(getEnd().getX());
		data.writeInt(getEnd().getY());
		
		for (int i = 0; i < this.getzAxis(); i++) 
			for (int j = 0; j < this.getxAxis(); j++) 
				for (int k = 0; k < this.getyAxis(); k++) 
					data.writeByte(this.array[i][j][k]);

		
		return array.toByteArray();
	}
	
	
	
	
	
	/**
	 *<h1>getValueByIndex</h1><p>
	 * <i> <ul>int getValueByIndex(int z, int x, int y)<i><p>
	 * Gets the value by given index.
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @return the value by index
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public int getValueByIndex(int z, int x, int y) throws IndexOutOfBoundsException{
		if (checkPositionBounds(z, x, y))
			return array[z][x][y];
		else
			throw new IndexOutOfBoundsException("{"+z+","+x+","+y+"} out of bound" );
	}
	
	
	/**
	 * <h1>getValueByIndex</h1><p>
	 * <i> <ul>int getValueByIndex(Position3D p)<i><p>
	 * Gets the value by given position.
	 *
	 * @param position p
	 * @return the value by index
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public int getValueByIndex(Position3D p) throws IndexOutOfBoundsException{
		if (checkPositionBounds(p))
			return array[p.getZ()][p.getX()][p.getY()];
		else
			throw new IndexOutOfBoundsException(" Position out of bound "+p.toString());
	}
	
	
	
	/**
	 * <h1>setWall</h1><p>
	 * <i> <ul>void setWall(int z, int x ,int y)<i><p>
	 * Set a wall in the maze in given index
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setWall(int z, int x ,int y)throws IndexOutOfBoundsException{ 
		if(checkPositionBounds(z, x, y))
			array[z][x][y] = WALL;
		else
			throw new IndexOutOfBoundsException(" Position out of bound "+new Position3D(z, x, y));
			
	}
	
	
	/**
	 * <h1> setPass</h1><p>
	 * <i> <ul>void setPass(int z, int x ,int y)<i><p>
	 * Set a passage in the maze in given index
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setPass(int z, int x ,int y)throws IndexOutOfBoundsException{
		if(checkPositionBounds(z, x, y))
			array[z][x][y] = PASS;
		else
			throw new IndexOutOfBoundsException(" Position out of bound "+new Position3D(z, x, y));
	}
	
	@Override
	public boolean equals(Object other) {
		Maze3D m = (Maze3D) other;
		
		if( !getMazeName().equals(m.getMazeName()))
			return false;
		
		if (getzAxis() == m.getzAxis() && getxAxis() == m.getxAxis()
				&& getyAxis() == m.getyAxis()) {
			if (start.equals(m.getStart())
					&& end.equals(m.getEnd())) {
				for (int i = 0; i < this.array.length; i++) {
					for (int j = 0; j < this.array[0].length; j++) {
						for (int j2 = 0; j2 < this.array[0][0].length; j2++) {
							if (this.array[i][j][j2] != m.getValueByIndex(i, j, j2)) {
								return false;
							}
						}
					}
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	


	/**
	 * <h1>setPass</h1><p>
	 * <i> <ul>void setPass(Position3D p)<i><p>
	 * Set a passage in the maze in given position
	 * @param Positon  - the index
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setPass(Position3D p)throws IndexOutOfBoundsException{
		if(checkPositionBounds(p))
			array[p.getZ()][p.getX()][p.getY()] = PASS;
		else
			throw new IndexOutOfBoundsException(" Position out of bound "+p);
			
	}
	
	
	/**
	 * <h1>setCasing</h1><p>
	 * <i><ul>void setCasing(int z, int x ,int y)<i><p>
	 * Set a casing in the maze in given index
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setCasing(int z, int x ,int y)throws IndexOutOfBoundsException{
		if(checkPositionBounds(z, x, y))
			array[z][x][y] = CASING;
		else
			throw new IndexOutOfBoundsException(" Position out of bound "+new Position3D(z,x,y));
			
	}
	
	
	@Override
	public String toString() {
		StringBuilder  printMaze= new StringBuilder ();
		printMaze.append("Maze name: "+getMazeName()+"\n");
		printMaze.append("Maze entrace: "+ getStart()+"\n");
		printMaze.append("Maze exit: "+getEnd()+"\n");
		
		for(int z=0; z < zAxis; z++){
			for(int x=0; x < xAxis; x++){
				for(int y=0; y < yAxis; y++){
					printMaze.append(array[z][x][y]+ "   ");
				}
				printMaze.append("\n");
			}
			printMaze.append("\n");
		}
		return printMaze.toString();
		
		
	}
	
	
	/**
	 * <h1>setValueByIndex</h1><p>
	 * <i><ul>void setValueByIndex(int z,int x,int y, int value)<i><p>
	 * Sets the value by index.
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @param value 
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setValueByIndex(int z,int x,int y, int value)  throws IndexOutOfBoundsException{
		if(checkPositionBounds(z, x, y))
			array[z][x][y] = value;
		else 
			throw new IndexOutOfBoundsException(" Position out of bound "+new Position3D(z,x,y));
	}
	
	
	/**
	 * <h1>setValueByIndex</h1><p>
	 * <i><ul>void setValueByIndex(Position3D p,int  value)<i><p>
	 * Sets the value by index.
	 * @param Position3D
	 * @param int value 
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public void setValueByIndex(Position3D p,int  value)throws IndexOutOfBoundsException{
		if(checkPositionBounds(p)) 
			array[p.getZ()][p.getX()][p.getY()] = value;
		else 
			throw new IndexOutOfBoundsException(" Position out of bound "+p);
		
	}
	
	
	/**
	 * <h1>getPossibleMovesAsString</h1><p>
	 * <i><ul>String [] getPossibleMovesAsString(Position3D p)<i><p>
	 * Gets the possible moves of given position as a string
	 *
	 * @param Position3D pos
	 * @return String[] all moves
	 */
	public String [] getPossibleMovesAsString(Position3D p){
		
		ArrayList<Position3D> pMoves = getPossibleMoves(p);
		String[] possibleMovesArray = new String[pMoves.size()];
		// copy from list to array
		for (int i = 0; i < possibleMovesArray.length; i++) {
			possibleMovesArray[i] = pMoves.get(i).toString();
		}
		
		return possibleMovesArray;	
	}
	
	
	/**
	 * <h1>getPossibleMoves</h1><p>
	 * <i><ul>ArrayList<Position3D> getPossibleMoves(Position3D pos)<i><p>
	 * Get all optional moves of given position by
	 * using {@link Position3D#MergePos(Position3D, Position3D)} method
	 * @param Position3D - pos 
	 * @return ArrayList<Position> - list of all optional moves
	 */
	public ArrayList<Position3D> getPossibleMoves(Position3D pos){
		ArrayList<Position3D> pMoves = new ArrayList<Position3D>();		
		Position3D temp = Position3D.MergePos(pos, Position3D.UP);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ()-1, temp.getX(), temp.getY())==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position3D.MergePos(pos, Position3D.DOWN);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ()+1, temp.getX(), temp.getY())==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position3D.MergePos(pos, Position3D.RIGHT);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ(), temp.getX(), temp.getY()-1)==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position3D.MergePos(pos, Position3D.LEFT);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ(), temp.getX(), temp.getY()+1)==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position3D.MergePos(pos, Position3D.BACKWARD);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ(), temp.getX()-1, temp.getY())==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}
		temp = Position3D.MergePos(pos, Position3D.FORWARD);
		if(checkPositionBoundsNoException(temp)){
			if( getValueByIndex(temp.getZ(), temp.getX()+1, temp.getY())==0 && getValueByIndex(temp)==0){
				pMoves.add(temp);
			}
		}

		return pMoves;
	}
	
	
	
	
	/**
	 * <h1>getAllMoves</h1><p>
	 * <i><ul>ArrayList<Position3D> getAllMoves(Position3D pos)<i><p>
	 *	Calculate all the moves of given position
	 *	using {@link Position3D#MergePos(Position3D, Position3D)} method
	 * @param pos the pos
	 * @return ArrayList - All moves
	 */
	public ArrayList<Position3D> getAllMoves(Position3D pos){
		ArrayList<Position3D> aMoves = new ArrayList<Position3D>();
		
		aMoves.add(Position3D.MergePos(pos, Position3D.UP));
		aMoves.add(Position3D.MergePos(pos, Position3D.DOWN));
		aMoves.add(Position3D.MergePos(pos, Position3D.RIGHT));
		aMoves.add(Position3D.MergePos(pos, Position3D.LEFT));
		aMoves.add(Position3D.MergePos(pos, Position3D.BACKWARD));
		aMoves.add(Position3D.MergePos(pos, Position3D.FORWARD));
		return aMoves;
		
	}


	/**
	 * <h1>checkPositionBounds</h1><p>
	 * <i><ul>boolean checkPositionBounds(int z, int x, int y)<i><p>
	 * Check if the given index is valid
	 *
	 * @param z - the zAxis damnation
	 * @param x - the xAxis damnation
	 * @param y - the yAxis damnation
	 * @return true, if valid, else  false
	 */
	public boolean checkPositionBounds(int z, int x, int y) {
		return ((z >= 0 && z < getzAxis()) && (x >= 0 && x < getxAxis()) && (y >= 0 && y < getyAxis()));
	}
	
	/**
	 * <h1>checkPositionBounds</h1><p>
	 * <i><ul>boolean checkPositionBounds(Position3D p)<i><p>
	 * Check if the given фнгпапно valid
	 *
	 * @param p - the position
	 * @return true, if valid, else  false
	 */
	public boolean checkPositionBounds(Position3D p) {
		return checkPositionBounds(p.getZ(), p.getX(), p.getY());
	}
	
	/**
	 * <h1>checkPositionBoundsNoException</h1><p>
	 * <i><ul>boolean checkPositionBoundsNoException(Position3D p)<i><p>
	 * Check if the given position valid without throwing exception
	 * @param  p - the position
	 * @return true, if valid, else  false
	 */
	public boolean checkPositionBoundsNoException(Position3D p) {
		return ((p.getZ()>=0 && p.getZ()<getzAxis())&&(p.getX() >= 0 &&p.getX()<getxAxis())&&(p.getY()>=0&&p.getY()<getyAxis()));

	}

	
	
	/**
	 * <h1>getCrossSectionByY</h1><p>
	 * <i><ul>int[][] getCrossSectionByY(int y)<i><p>
	 * @param y - the yAxis damnation
	 * @return int[][] the cross section by Y
	 * @throws IndexOutOfBoundsException the section is out of bounds exception
	 */
	public int[][] getCrossSectionByY(int y) throws IndexOutOfBoundsException{
		if(y>=0 && y < getyAxis()){
			int [][] crossByY = new int[getzAxis()][getyAxis()];
			for ( int i=0; i<getzAxis(); i++){
				for( int j=0; j<getyAxis(); j++){
					crossByY[i][j]=array[i][j][y];
				}
			}
			return crossByY;
		}else
			throw new IndexOutOfBoundsException("invalid index "+ y);
	}
	
	/**
	 * <h1>getCrossSectionByZ</h1><p>
	 * <i><ul>int[][] getCrossSectionByZ(int z)<i><p>
	 * @param z - the zAxis damnation
	 * @return int[][] the cross section by Z
	 * @throws IndexOutOfBoundsException the section is out of bounds exception
	 */
	public int[][] getCrossSectionByZ(int z)throws IndexOutOfBoundsException{
		if(z>=0 && z < this.getzAxis()){
			int [][] crossByZ = new int[getxAxis()][getyAxis()];
			
			for ( int i=0; i<getxAxis(); i++){
				for( int j=0; j<getyAxis(); j++){
					crossByZ[i][j]=array[z][i][j];
				}
			}
			return crossByZ;
		}
		else
		{
			throw new IndexOutOfBoundsException("invalid index "+ z);
		}
	}
	
	/**
	 * <h1>getCrossSectionByX</h1><p>
	 * <i><ul>int[][] getCrossSectionByX(int x)<i><p>
	 * @param x - the xAxis damnation
	 * @return imt[][] the cross section by X
	 * @throws IndexOutOfBoundsException the section is out of bounds exception
	 */
	public int[][] getCrossSectionByX(int x)throws IndexOutOfBoundsException  {
		if(x>=0 && x < this.getxAxis())
		{
			int [][] crossByX = new int[this.getzAxis()][this.getxAxis()];
			for ( int i=0; i<this.getzAxis(); i++)
			{
				for( int j=0; j<this.getyAxis(); j++)
					crossByX[i][j]=array[i][x][j];	
			}
			return crossByX;
		}
		else
			throw new IndexOutOfBoundsException("invalid index "+ x);
	}
	
	
	
	/**
	 * <h1>printCrossByAxis</h1><p>
	 * <i><ul>String printCrossByAxis(int [][] arr)<i><p>
	 * Prints the cross section
	 *
	 * @param arr - the section
	 */
	public String printCrossByAxis(int [][] arr){

		StringBuilder sb = new StringBuilder();
		for (int i=0;i<arr.length;i++){
			for( int j=0; j<arr[i].length;j++){
				sb.append(arr[i][j]+"   "); 
			}
			sb.append("\n");	
		}
		return sb.toString();
	}
	
	
	/**
	 * <h1>createRandomPosition</h1><p>
	 * <i><ul>Position3D createRandomPosition()<i><p>
	 *
	 * @return Position - random position
	 */
	public Position3D createRandomPosition(){

		r = new Random();
		int wall = r.nextInt(6);
		int z=0,x=0,y=0;

		switch (wall) {
		case 5:// if at ceiling
			z = getzAxis()-2;
			while(x%2==0)
				x = r.nextInt(getxAxis()-2)+1;
			while (y%2==0)
				y = r.nextInt(getyAxis()-2)+1;
			break;
		case 0: // if at floor
			z=1;
			while(x%2==0)
				x = r.nextInt(getxAxis()-2)+1;
			while (y%2==0)
				y = r.nextInt(getyAxis()-2)+1;
			break;
		case 1://if at left edge
			while (z%2 ==0)
				z = r.nextInt(getzAxis()-2)+1;
			while(x%2==0)
				x = r.nextInt(getxAxis()-2)+1;
			//y = 1;
				y = 1;
			break;
		case 2: //if at right edge
			while (z%2 ==0)
				z = r.nextInt(getzAxis()-2)+1;
			while(x%2==0)
				x = r.nextInt(getxAxis()-2)+1;
			// y = myMaze.getyAxis()-2;
			y = getyAxis()-2;
			break;
		case 3: //if at backward edge
			while (z%2 ==0)
				z = r.nextInt(getzAxis()-2)+1;
			x = 1;
			//x=1;
			while (y%2==0)
				y = r.nextInt(getyAxis()-2)+1;
			break;
		case 4: //if at forward edge
			while (z%2 ==0)
				z = r.nextInt(getzAxis()-2)+1;
			x = getxAxis()-2;
			//x=myMaze.getxAxis()-2;
			while (y%2==0)
				y = r.nextInt(getyAxis()-2)+1;
			break;
		}
		
		return new Position3D(z,x,y);
	}
	
	/**
	 * <h1>carvePosition</h1><p>
	 * <i><ul>Position3D carvePosition(Position3D p)<i><p>
	 * carve the position from the edge of the maze
	 * @return Position - the position to carve
	 */
	public Position3D carvePosition(Position3D p){
		Position3D temp = new Position3D(p);
		if(temp.getZ()==0){  //Check if start position at the floor
			temp.setZ(1);
			setPass(temp);
		}else if(temp.getZ()==getzAxis()-1){//Check if start position at the ceiling
			temp.setZ(getzAxis()-2);
			setPass(temp);
		}


		if(temp.getX()!=0 && (temp.getY()==0 )){  //Check if start position at the floor
			temp.setY(1);
			setPass(temp);
		}else if(temp.getY()==getyAxis()-1){//Check if start position at the ceiling
			temp.setY(getyAxis()-2);
			setPass(temp);
		}	

		if(temp.getX()==0){  //Check if start position at the floor
			temp.setX(1);
			setPass(temp);
		}else if(temp.getX()==getxAxis()-1){//Check if start position at the ceiling
			temp.setX(getyAxis()-2);
			setPass(temp);
		}
		
		return temp;
	}



	



	

	
	


}
