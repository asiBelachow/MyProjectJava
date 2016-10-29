package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public abstract class AbstractPresenter  implements Presenter,Observer {

	Model model;
	View view;
	
	public AbstractPresenter(Model model, View view) {
		
		this.model = model;
		this.view =view;
		
	}

	@Override
	public abstract void update(Observable o, Object arg);

	
	
	

}
