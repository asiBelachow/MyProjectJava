package commands;

import java.io.IOException;
import java.util.HashMap;

import algorithms.search.Solution;
import maze.maze3d.*;
import model.Model;
import model.MyModel;
import position.position3d.*;
import view.View;




/**
 *	<h1>CommandManger</h1><p>
 * 	The Class CommandManger hold all the command 
 */
public class CommandManger {
	
	/** The model. */
	Model model;
	
	/** The view. */
	View view;
	
	/**
	 * <h1>Command Manger</h1><p>
	 * <i><ul>CommandManger(Model model, View view)<i><p>
	 * Instantiates a new command manger.
	 * @param model the {@link MyModel}
	 * @param view the view
	 */
	public CommandManger(Model model, View view) {
		this.model = model;
		this.view =view;
	}
	
	/**
	 * <h1>Get Model</h1><p>
	 * <i><ul>Model getModel()<i><p>
	 * return the data member model
	 * @return model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * <h1>Set Model</h1><p>
	 * <i><ul>Model getModel()<i><p>
	 * Set the data member model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * <h1>Get View</h1><p>
	 * <i><ul>View getView()<i><p>
	 * return the data member view
	 * @return view
	 */
	public View getView() {
		return view;
	}

	/**
	 * <h1>Set View</h1><p>
	 * <i><ul>View setView()<i><p>
	 * Set the data member view
	 */
	public void setView(View view) {
		this.view = view;
	}
	
	/**
	 * <h1>Get CommandMap</h1><p>
	 * <i><ul>HashMap<String,Command> getCommandMap()<i><p>
	 * This method initialize the HashMap with<br>
	 * the command name and the command
	 * @return HashMap<String,Command> - Constructed HashMap of the command
	 */
	public HashMap<String,Command> getCommandMap(){
		
		HashMap<String, Command> commands = new HashMap<String, Command>();
		commands.put("dir [^\n]+", new DirPathCommand());
		commands.put("generate_maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}", new GenerateMazeCommand());
		commands.put("display [A-Za-z0-9]+", new DisplayMazeCommand());
		commands.put("display_cross_section [0-9]{1,2} [A-Za-z0-9]+ [A-Za-z0-9]+", new DisplayCrossSectionCommand());
		commands.put("save_maze [A-Za-z0-9]+ [^\n]+", new SaveMazeCommand());
		commands.put("load_maze [^\n]+ [A-Za-z0-9]+", new LoadMazeCommand());
		commands.put("solve [A-Za-z0-9]+ [A-Za-z0-9]+", new SolveMazeCommand());
		commands.put("display_solution [A-Za-z0-9]+", new DisplaySolutionCommand());
		commands.put("display_menu", new DisplayMazeCommand());
		commands.put("list_maze", new ListNameOfMazeCommand());
		commands.put("menu", new DisplayMenuCommand());
		commands.put("maze_ready", new NotifyMazeReadyCommand());
		commands.put("solution_ready", new NotifySolutionReady());
		commands.put("dir_path", new DisplayDirFilesCommand());
		commands.put("exit", new ExitCommand());
		commands.put("message [^\n]+", new MessageCommand());
		return commands;

	}
	
	/**
	 * <h1>Get Regex Command</h1><p>
	 * <i><ul>HashMap<String,String> getRegexCommand()<i><p>
	 * This method initialize the HashMap with<br>
	 * the command name and  regular expression string<br>
	 * that the command name must match.
	 * @return HashMap<String,Command> - Constructed HashMap of the regular expression
	 */
	public HashMap<String,String> getRegexCommand(){
		HashMap<String,String> regexCommands = new HashMap<String,String>();
		
		regexCommands.put("dir","dir [^\n]+");
		regexCommands.put("generate_maze", "generate_maze [A-Za-z0-9]+ [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}");
		regexCommands.put("display", "display [A-Za-z0-9]+");
		regexCommands.put("display_cross_section", "display_cross_section [0-9]{1,2} [A-Za-z0-9]+ [A-Za-z0-9]+");
		regexCommands.put("save_maze", "save_maze [A-Za-z0-9]+ [^\n]+");
		regexCommands.put("load_maze", "load_maze [^\n]+ [A-Za-z0-9]+");
		regexCommands.put("solve", "solve [A-Za-z0-9]+ [A-Za-z0-9]+");
		regexCommands.put("display_solution", "display_solution [A-Za-z0-9]+");
		regexCommands.put("display_menu", "display_menu");
		regexCommands.put("list_maze","list_maze");
		regexCommands.put("menu", "menu");
		regexCommands.put("maze_ready", "maze_ready");
		regexCommands.put("solution_ready", "solution_ready");
		regexCommands.put("dir_path", "dir_path");
		regexCommands.put("message", "message [^\n]+");
		regexCommands.put("exit", "exit");
 		return regexCommands;
		
	}
	
	/**
	 * The Class GenerateMazeCommand.
	 */
	class GenerateMazeCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			model.generateMaze3D(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]));
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	
	/**
	 * The Class DirPathCommand.
	 */
	class DirPathCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			model.getDirPath(param[1]);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class DisplayMazeCommand.
	 */
	class DisplayMazeCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			Maze3D maze = model.displayMaze(param[1]);
		
			if (maze==null){
				System.out.println("hjk");
				view.displayMessage("A maze with name \""+" "+param[1]+"\" already exists");
			}
			else
				view.displayMaze(maze);
			
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class DisplayCrossSectionCommand.
	 */
	class DisplayCrossSectionCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			int[][] cross = model.CrossSectionByDimention(Integer.parseInt(param[1]), param[2], param[3]);
			if(cross == null)
				view.displayMessage("There was error while trying to disply cros section, please try again");
			else
				view.getCrossSection(cross);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	
	/**
	 * The Class SaveMazeCommand.
	 */
	class SaveMazeCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			view.displayMessage(model.saveMaze(param[1], param[2]));
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class LoadMazeCommand.
	 */
	class LoadMazeCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			Maze3D maze = model.loadMaze(param[1], param[2]);
			if(maze==null)
				view.displayMessage("There was error while trying to load the maze, Please try agian");
			else
				view.displayMaze(maze);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class SolveMazeCommand.
	 */
	class SolveMazeCommand implements Command{

		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			model.solveMaze(param[1], param[2]);

		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
		
	/**
	 * The Class DisplaySolutionCommand.
	 */
	class DisplaySolutionCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			Solution<Position3D> s =model.displaySolution(param[1]);
			if( s ==null){
				view.displayMessage("The maze not found");
			}
			else{
				System.out.println(s.toString());
			view.displaySolution(s);
		}

	}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class ListNameOfMazeCommand.
	 */
	class ListNameOfMazeCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			view.displayMessage(model.displayListOfAllMaze());
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class DisplayMenuCommand.
	 */
	class DisplayMenuCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			view.displayMessage(model.displayMenu());
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class ExitCommand.
	 */
	class ExitCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			model.exit();
			view.close();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class NotifyMazeReadyCommand.
	 */
	class NotifyMazeReadyCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			String name = param[0];
			view.notifyMazeIsReady(name);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class NotifySolutionReady.
	 */
	class NotifySolutionReady implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			String name = param[0];
			//string msg = "Solution "
			view.notifySolutionIsReady(name);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The Class DisplayDirFilesCommand.
	 */
	class DisplayDirFilesCommand implements Command{
		
		/* (non-Javadoc)
		 * @see commands.Command#doCommmand(java.lang.String[])
		 */
		@Override
		public void doCommmand(String[] param) throws IOException {
			String str = param[0];
			view.displayMessage(str);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
		
	}
	
	class MessageCommand implements Command{

		@Override
		public void doCommmand(String[] param) throws IOException {
			System.out.println("message");
			view.displayMessage(param[0]);
			
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
		
	}
	
}
	


