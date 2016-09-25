package algorithms.maze3DGenerators;

import java.io.Serializable;

/**
 * This class Position represent the cell in the 3d maze </br>
 * by z,x,y damnation [z][x][y]
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class Position implements Serializable {
	
	//------------------------------Data Members-------------------------//
	
	private static final long serialVersionUID = 3118754725894045017L;

	/** The Constant UP. */
	public static final Position UP = new Position(2,0, 0);
	
	/** The Constant DOWN. */
	public static final Position DOWN = new Position(-2, 0, 0);
	
	/** The Constant RIGHT. */
	public static final Position RIGHT = new Position(0, 0, 2);
	
	/** The Constant LEFT. */
	public static final Position LEFT = new Position(0, 0, -2);
	
	/** The Constant FORWARD. */
	public static final Position FORWARD = new Position(0, -2, 0);
	
	/** The Constant BACKWARD. */
	public static final Position BACKWARD = new Position(0, 2, 0);
	
	/** The z damnation */
	private int z;
	
	/** The x damnation */
	private int x;
	
	/** The y damnation */
	private int y;
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 *<h1>Position</h1><p>
	 * <i><ul>Position()<i><p>
	 * Initialize a new Position - default CTOR
	 */
	public Position() {
		
	}
	
	public Position(String position) {
		
		String[] s = position.substring(1, position.length()-1).split(",");
		this.z = Integer.parseInt(s[0]);
		this.x = Integer.parseInt(s[1]);
		this.y = Integer.parseInt(s[2]);
	}
	
	/**
	 *<h1>Position</h1><p>
	 * <i><ul>Position(Position p)<i><p>
	 * Initialize a new Position - Copy CTOR
	 */
	public Position(Position p) {
		this.setZ(p.getZ());
		this.setX(p.getX());
		this.setY(p.getY());
	}
	
	
	/**
	 * Constructor
	 *
	 * @param z - the z damnation.
	 * @param x - the x damnation.
	 * @param y - the y damnation.
	 * 
	 */
	public Position(int z , int x , int y) {
		this.setZ(z);
		this.setX(x);
		this.setY(y);
	}


	
	//-----------------------------setters and getters-------------------//

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

	//------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("{"+(getZ())+","+(getX())+","+(getY())+"}");
		
		return str.toString();
	}
	
	
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Position))
			return false;

		Position pos = (Position) obj;

		if (this.z == pos.getZ() && this.x== pos.getX() && this.y == pos.getY()) {
			return true;
		}

		return false;
		
	}

	
	/**
	 * <h1>MergePos</h1></br>
	 *  <i> <ul>MergePos(Position pos1, Position pos2)<i><p>
	 * This method merge two positions by adding the value of the z,x,y dimensions to a new position</br>
	 *
	 * @param Position pos1
	 * @param Position pos2
	 * @return Position
	 */
	public static Position MergePos(Position pos1, Position pos2) {
		int z = pos1.getZ() + pos2.getZ();
		int x = pos1.getX() + pos2.getX();
		int y = pos1.getY() + pos2.getY();
		return new Position(z, x, y);
	}
		

}
