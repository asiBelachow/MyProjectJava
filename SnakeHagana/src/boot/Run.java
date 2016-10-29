package boot;

import model.MyModel;
import presenter.MyPresenter;
import view.SnakeWindow;

public class Run {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		
		SnakeWindow sw = new SnakeWindow("Snake", 800, 600);
		MyPresenter presenter = new MyPresenter(model, sw);
		model.addObserver(presenter);
		sw.addObserver(presenter);
		sw.run();

	}

}
