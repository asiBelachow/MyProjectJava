package algorithms.maze3DGenerators;

import maze.maze3d.Maze3D;
import position.position3d.Position3D;

/**
 * This class SimpleMaze3dGenerator define a simple algorithm to build 3d maze 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public class SimpleMaze3dGenerator extends CommonMaze3DGenerator {

	@Override
	public Maze3D generate(int zAxis, int xAxis, int yAxis) {
		
		myMaze = new Maze3D(zAxis, xAxis, yAxis);
		initMaze();
		
		//Set random start position
		myMaze.setStart(myMaze.createRandomPosition());
		//Set random end position
		myMaze.setEnd(myMaze.createRandomPosition());
		
		
		while ((Math.abs(myMaze.getStart().getZ()-myMaze.getEnd().getZ()))<2){
			myMaze.setEnd(myMaze.createRandomPosition());
		}
		
		
		myMaze.setPass(myMaze.getStart());
		myMaze.setPass(myMaze.getEnd());
	
		createPathFromStartToEnd();;
		return this.myMaze;
	}
	
	
	
	/**
	 * <h1>Create path from start to end</h1><p>
	 * <i> <ul>createPathFromStartToEnd()<i><p>
	 * Create valid path from the entrance of the maze to the exit <br>
	 * The path created by making a comparison between the dimensions<p>
	 * <b>For every dimension(z,x,y):</b><br>
	 * <i>if the dimension of the entrance greater(lesser) than the exit add(lessen) the z dimension<br>
	 * and set zero(break wall) to determine pass <br>
	 * until the entrance and exit are equal<i>
	 *<p>
	 */
	public void createPathFromStartToEnd(){
		Position3D start = new Position3D(myMaze.getStart());
		Position3D end = new Position3D(myMaze.getEnd());

		//while(!start.equals(end)){

		while(start.getZ()!=end.getZ()){
			if (start.getZ()>end.getZ()  && start.getZ()>2){
				myMaze.setPass(start.getZ()-1, start.getX(), start.getY());
				start.setZ(start.getZ()-2);
				myMaze.setPass(start);
				//System.out.println(start + "down");
				//moveToEnd(start, end);
			}
			else if (start.getZ()< end.getZ()  && start.getZ()<myMaze.getzAxis()-3){
				myMaze.setPass(start.getZ()+1, start.getX(), start.getY());
				start.setZ(start.getZ()+2);
				myMaze.setPass(start);
				//System.out.println(start + "up");
				//moveToEnd(start, end);
			}	
		}
		
		while(start.getX()!=end.getX()){
			if(start.getX() > end.getX() && start.getX()> 2){
				myMaze.setPass(start.getZ(), start.getX()-1, start.getY());
				start.setX(start.getX()-2);
				myMaze.setPass(start);
				//System.out.println(start + " forward");
			}
			else if (start.getX() < end.getX() && start.getX()< myMaze.getxAxis()-3){
				myMaze.setPass(start.getZ(), start.getX()+1, start.getY());
				start.setX(start.getX()+2);
				myMaze.setPass(start);
				//System.out.println(start + "backward");
			}
		}
		
		while(start.getY()!=end.getY()){
			if(start.getY() > end.getY() && start.getY()> 2){
				myMaze.setPass(start.getZ(), start.getX(), start.getY()-1);
				start.setY(start.getY()-2);
				myMaze.setPass(start);
				//System.out.println(start + " left");
			}
			else if (start.getY() < end.getY() && start.getY()< myMaze.getyAxis()-3){
				myMaze.setPass(start.getZ(), start.getX(), start.getY()+1);
				start.setY(start.getY()+2);
				myMaze.setPass(start);
				//System.out.println(start + "right");
			}
		}
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
				for( int y=0; y < myMaze.getyAxis(); y++){
					if(z==0 || z == myMaze.getzAxis()-1){ //If we are in the floor or the  set CASING(2)
						myMaze.setCasing(z, x, y);
					}
					else if( x==0  || x==myMaze.getxAxis()-1 || y==0 || y==myMaze.getyAxis()-1 )//If we are in the border
						myMaze.setCasing(z, x, y);                                              //of the maze set CASING(2)
					else if ((x%2!=0 || y%2!=0) && z%2!=0 )
						myMaze.setValueByIndex(z, x, y, r.nextInt(2));//If we are in odd cell set WALL(1) or PASS(0)
					else
						myMaze.setWall(z, x, y); //Set PASS(0)
				}
			}
		}
	}
	
	
}
