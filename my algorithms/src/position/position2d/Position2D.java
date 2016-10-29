package position.position2d;

/**
 * This class Position represent the cell in the 2D maze </br>
 * by x,y damnation [x][y]
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class Position2D extends CommonPosition2D {


	//------------------------------Data Members-------------------------//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -152698980768349303L;

	private int x;
	
	private int y;
	
	
	/** The Constant RIGHT. */
	public static final Position2D RIGHT = new Position2D(0, 1);
	
	/** The Constant LEFT. */
	public static final Position2D LEFT = new Position2D(0, -1);
	
	/** The Constant FORWARD. */ 
	public static final Position2D FORWARD = new Position2D(-1,0);
	
	/** The Constant BACKWARD. */
	public static final Position2D BACKWARD = new Position2D(1, 0);
	
	
	//------------------------------Constructors-------------------------//
	
	
	/**
	 *<h1>Position</h1><p>
	 * <i><ul>Position2D()<i><p>
	 * Initialize a new Position - default CTOR
	 */
	public Position2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public Position2D(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	/**
	 *<h1>Position</h1><p>
	 * <i><ul>Position2D()<i><p>
	 * Initialize a new Position - Copy CTOR
	 */
	public Position2D(Position2D p) {
		setX(p.getX());
		setY(p.getY());
	}
	
	
	/**
	 *<h1>Position</h1><p>
	 * <i><ul>Position2D(String position)<i><p>
	 * Initialize a new Position from a string that represent position
	 */
	public Position2D(String position) {
		
		String[] s = position.substring(1, position.length()-1).split(",");
		this.x = Integer.parseInt(s[0]);
		this.y = Integer.parseInt(s[1]);
	}
	
	
	//-----------------------------setters and getters-------------------//
	
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
	
	//-------------------------Functionality-------------------------//

	@Override
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		str.append("{"+(getX())+","+(getY())+"}");
		return str.toString();
		
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Position2D))
			return false;

		Position2D pos = (Position2D) obj;

		if (this.x== pos.getX() && this.y == pos.getY()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * <h1>MergePos</h1></br>
	 *  <i> <ul>MergePos(Position pos1, Position pos2)<i><p>
	 * This method merge two positions by adding the value of the x,y dimensions to a new position</br>.
	 *
	 * @param pos1 - Position 1
	 * @param pos2 - Position 2
	 * @return Position2D - The merge position
	 */
	public static Position2D MergePos(Position2D pos1, Position2D pos2) {
		int x = pos1.getX() + pos2.getX();
		int y = pos1.getY() + pos2.getY();
		return new Position2D(x, y);
	}
	
	
	
}
