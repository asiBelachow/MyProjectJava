package algorithms.maze3DGenerators;

import java.util.ArrayList;
import java.util.Iterator;

import maze.maze3d.Maze3D;
import position.position3d.Position3D;


/**
 * This class GrowingTreeGenerator define the growing tree algorithm to build 3d maze 
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class GrowingTreeGenerator extends CommonMaze3DGenerator {
	
	//------------------------------Data Members-------------------------//
	
	GrowingTree gt;
	
	
	/**
	 *<h1>Constructor of Growing Tree Generator</h1><p>
	 * <i> <ul>GrowingTreeGenerator(GrowingTree gt)<i><p>
	 */
	public GrowingTreeGenerator(GrowingTree gt) {
		this.gt = gt;
	}

	@Override
	public Maze3D generate(int zAxis, int xAxis, int yAxis) {
		myMaze = new Maze3D(zAxis, xAxis, yAxis);  	//Create the maze
		
		initMaze();//Initialization of the maze
		
		ArrayList<Position3D> C = new ArrayList<Position3D>();  //Define the list 
		                                                    //that will hold the positions
		 //Get random start position(not on the shell)
		Position3D randPos = chooseRandomPosition();
		
		//Set pass 
		myMaze.setPass(randPos);
		
		//Add the maze's entrance position to the list C
		C.add(randPos);
		
		//Build the maze as long as C is not empty
		while(!C.isEmpty()){
			//Get next position by choosing one of the options <last or random>
			Position3D c = gt.choosePosition(C); 
			//Get unvisited neighbors of the position that chosen
			ArrayList<Position3D> neighbors = findUnvisitedNeighbors(c);
			
			if(!neighbors.isEmpty()){//If the position have neighbors
				
				Position3D n = neighbors.get(r.nextInt(neighbors.size())); 
				
				createPath(c, n);//Create path from c to n and add n to C
				
				C.add(n);//Add the neighbor n to C
				
				//Set pass in n position
				myMaze.setPass(n);
			}
			//If the position have no neighbors remove it from C
			else
				C.remove(c);
		}
		//Set random start and end position
		myMaze.setStart(choosePassPosition());
		Position3D p = choosePassPosition();
		while ( Math.abs( myMaze.getStart().getZ() - p.getZ()) <2)
			p = choosePassPosition();
		myMaze.setEnd(p);
		return myMaze;
	}
	
	
	/**
	 * <h1>Initialization of the 3d maze</h1><p>
	 * <i> <ul>initMaze()<i><p>
	 * Set the shell of the 3d  maze with CASING(2) and<br>
	 * set all walls in the maze with WALL(1)
	 * and all other cell with WALL(1) or PASS(0)
	 *<b>Note:</b><p> 
	 *use {@link #setCasing(int, int, int)}<br>
	 *use {@link #setValueByIndex(int, int, int)}<br>
	 *use {@link #setWall(int, int, int)}
	 *<p>
	 */
	private void initMaze(){
		for(int z=0; z < myMaze.getzAxis(); z++){
			for(int x=0; x < myMaze.getxAxis(); x++){
				for( int y=0; y < myMaze.getyAxis(); y++){       ///Initial the maze with casing(2) on 
					if(z==0 || z == myMaze.getxAxis()-1)         ///the shell and walls (1)
						myMaze.setCasing(z, x, y);
					else if( x==0  || x==myMaze.getxAxis()-1 || y==0 || y==myMaze.getxAxis()-1 )
						myMaze.setCasing(z, x, y);
					else
						myMaze.setWall(z, x, y);
				}
			}
		}
	}
	
	
	/**
	 * <h1>Find unvisited neighbors</h1><p>
	 * <i> <ul>ArrayList<Position> findUnvisitedNeighbors(Position pos)<i><p>
	 *
	 * @param pos the pos
	 * @return the array list
	 */
	private ArrayList<Position3D> findUnvisitedNeighbors(Position3D pos){
		
		ArrayList<Position3D> neighbors  = myMaze.getAllMoves(pos);
	
		Iterator<Position3D> iter = neighbors.iterator();
		
		while ( iter.hasNext()){
			Position3D temp = iter.next();
			if( !(myMaze.checkPositionBoundsNoException(temp))){// && (getValueByIndex(temp) != 0) )
				iter.remove();
				continue;
			}
			if(myMaze.getValueByIndex(temp) == 0)
				iter.remove();
		}
		return neighbors;	
	}
	
	

	private void createPath(Position3D a,Position3D b){
		
		if (a.getX()+2==b.getX()){
			myMaze.setPass(a.getZ(), a.getX()+1, a.getY());
			myMaze.setPass(a.getZ(), a.getX()+2, a.getY());
		}
		
		if (a.getX()-2==b.getX()){
			myMaze.setPass(a.getZ(), a.getX()-1, a.getY());
			myMaze.setPass(a.getZ(), a.getX()-2, a.getY());
		}
		
		if (a.getY()+2==b.getY()){
			myMaze.setPass(a.getZ(), a.getX(), a.getY()+1);
			myMaze.setPass(a.getZ(), a.getX(), a.getY()+2);
		}
		
		if (a.getY()-2==b.getY()){
			myMaze.setPass(a.getZ(), a.getX(), a.getY()-1);
			myMaze.setPass(a.getZ(), a.getX(), a.getY()-2);
		}
		
		if (a.getZ()+2==b.getZ()){
			myMaze.setPass(a.getZ()+1, a.getX(), a.getY());
			myMaze.setPass(a.getZ()+2, a.getX(), a.getY());
		}
		
		if (a.getZ()-2==b.getZ()){
			myMaze.setPass(a.getZ()-1, a.getX(), a.getY());
			myMaze.setPass(a.getZ()-2, a.getX(), a.getY());
		}	
	}
	
	
	private Position3D chooseRandomPosition() {	
		int x = r.nextInt(myMaze.getxAxis()/2)*2+1;
		int y = r.nextInt(myMaze.getyAxis()/2)*2+1;
		int z = r.nextInt(myMaze.getzAxis()/2)*2+1;
		return new Position3D(z,x, y);
	}
	
	private Position3D choosePassPosition(){
		Position3D p = chooseRandomPosition();
		while ( myMaze.getValueByIndex(p)!=0)
			p = chooseRandomPosition();
		
		return p;
	}
	
	
	
	

}
