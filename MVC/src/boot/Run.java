package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.CLI;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		
		MyController c = new MyController();
		MyModel m = new MyModel(c);
		MyView v = new MyView(c);
		c.setModel(m);
		c.setView(v);
		c.setCommands();
		CLI client = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out,true),v,c.getCommands());
		v.setCli(client);
		v.start();
		

	}

}