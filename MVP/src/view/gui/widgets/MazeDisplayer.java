package view.gui.widgets;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import position.position3d.*;
import view.gui.MazeWinEventHandler;

public abstract class MazeDisplayer extends Canvas implements GameBoardDisplayAdapter {

	
	protected MazeWinEventHandler winEvent;
	protected Position3D position;
	protected Image winImage;
	protected Image goalImage;
	protected Image hintImage;
	protected HashMap<String, Image> backgrounds;
	protected HashMap<String, ImageGameCharacter> characters;
	protected ImageGameCharacter character;
	protected int numofSteps;
	
	
	
	// Just a stub..
	int[][] mazeData={
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,1,1,0,1,0,0,1},
			{0,0,1,1,1,1,1,0,0,1,0,1,0,1,1},
			{1,1,1,0,0,0,1,0,1,1,0,1,0,0,1},
			{1,0,1,0,1,1,1,0,0,0,0,1,1,0,1},
			{1,1,0,0,0,1,0,0,1,1,1,1,0,0,1},
			{1,0,0,1,0,0,1,0,0,0,0,1,0,1,1},
			{1,0,1,1,0,1,1,0,1,1,0,0,0,1,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
			};
	
	
	//------------------------------Constructors-------------------------//
	
	
	public MazeDisplayer(Composite parent, int style) {
		super(parent, style);
		setNumofSteps(0);
		character = new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image1.png"));
		initImages();
		initCharacters();
		initBackgrounds();
	};

	public HashMap<String, Image> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(HashMap<String, Image> backGrounds) {
		this.backgrounds = backGrounds;
	}
	
	public void initImages(){
		winImage = new Image(getDisplay(), "resources/image/wins/win_image.jpg");
		goalImage = new Image(getDisplay(), "resources/image/characters/goal_image.png");
	}
	
	public void initCharacters(){
		
		characters = new HashMap<String, ImageGameCharacter>();
		characters.put("marco 1", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image1.png")));
		characters.put("marco 2", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image2.png")));
		characters.put("sonic", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image3.png")));
		characters.put("mario", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image4.png")));
		characters.put("son goku 1", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image5.png")));
		characters.put("son goku 2", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image6.png")));
		characters.put("hitman", new ImageGameCharacter(this, SWT.NONE, new Image(getDisplay(), "resources/image/characters/character_image7.png")));
	}

	public void initBackgrounds(){
		backgrounds = new HashMap<String, Image>();
		backgrounds.put("game_background",new Image(getDisplay(), "resources/image/backgrounds/bg_image.png"));
		backgrounds.put("background_red", new Image(getDisplay(), "resources/image/backgrounds/background_red.png"));
		backgrounds.put("background_green", new Image(getDisplay(), "resources/image/backgrounds/background_green.png"));
		backgrounds.put("background_blue", new Image(getDisplay(), "resources/image/backgrounds/background_blue.png"));
		backgrounds.put("background_yellow", new Image(getDisplay(), "resources/image/backgrounds/background_yellow.png"));
		backgrounds.put("background_white", new Image(getDisplay(), "resources/image/backgrounds/background_white.png"));
		backgrounds.put("background_brown", new Image(getDisplay(), "resources/image/backgrounds/background_brown.png"));
		backgrounds.put("background_purple", new Image(getDisplay(), "resources/image/backgrounds/background_purple.png"));
		backgrounds.put("background_sunset", new Image(getDisplay(), "resources/image/backgrounds/background_sunset.png"));
		backgrounds.put("background_nature", new Image(getDisplay(), "resources/image/backgrounds/background_nature.png"));
	}
	
	//------------------------------Getters and Setters-------------------------//
	
	public int getNumofSteps() {
		return numofSteps;
	}

	public void setNumofSteps(int numofSteps) {
		this.numofSteps = numofSteps;
	}
	
	
	public MazeWinEventHandler getWinEvent() {
		return winEvent;
		
	}

	
	public void setWinEvent(MazeWinEventHandler winEvent) {
		this.winEvent = winEvent;
	}
	
	public int[][] getMazeData() {
		return mazeData;
	}


	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}
	

	public Position3D getPosition() {
		return position;
	}

	public void setPosition(Position3D position) {
		this.position = position;
	}

	public Image getWinImage() {
		return winImage;
	}

	public void setWinImage(Image winImage) {
		this.winImage = winImage;
	}

	public Image getGoalImage() {
		return goalImage;
	}

	public void setGoalImage(Image goalImage) {
		this.goalImage = goalImage;
	}

	public Image getHintImage() {
		return hintImage;
	}

	public void setHintImage(Image hintImage) {
		this.hintImage = hintImage;
	}

	public ImageGameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(ImageGameCharacter character) {
		this.character = character;
		setCharacterPosition(getPosition());
		redraw();
		
	}


	
	public HashMap<String, ImageGameCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(HashMap<String, ImageGameCharacter> characters) {
		this.characters = characters;
	}

	public void triggerWin() {
		if (winEvent != null)
			winEvent.winGame();
		else
			// if there is no win handler - use default syso
			System.out.println("Win!");
	}
	
	
	public abstract void moveUp();

	public abstract void moveDown();

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void moveFront();

	public abstract void moveBack();
	
	public abstract void setCharacterPosition(Position3D p);
	
	public abstract void moveCharacter(Position3D p);
	
	public abstract void showSoution(ArrayList<Position3D> sol);
	

		
	

	
	
}
