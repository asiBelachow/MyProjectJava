package presenter;


import java.util.Observer;
import model.Model;
import view.View;


/**
 *  <h1>AbstractPresenter</h1><p>
 *  This class defines the common functionality in order to</br>
 *  connect between the {@link Model} and the {@link View} </p>
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-20-09
 */
public abstract class AbstractPresenter implements Observer,Presenter {
	
	//------------------------------Data Members-------------------------//
	
	
	/** The model. */
	
	protected Model model;
	
	/** The view. */
	protected View view;


	
	//------------------------------Constructors-------------------------//
	

	/**
	 * <h1>Abstract Presenter</h1><p>
	 * <i><ul><ulAbstractPresenter(Model model, View view)<i><p>
	 * Instantiates a new Abstract Presenter
	 * @param model - {@link Model}
	 * @param view - {@link View}
	 */
	public AbstractPresenter(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	//------------------------------Data Members-------------------------//
	
	
	/**
	 * <h1>Set model</h1><p>
	 * <i><ul>void setModel(Model m)<i><p>
	 * Set the data member {@link Model} m
	 * @param m - the  model
	 */
	public void setModel(Model model){
		this.model = model;
	}
	
	
	/**
	 * <h1>Set view</h1><p>
	 * <i><ul>void setView(View v)<i><p>
	 * Set the data member {@link View} v
	 * @param v - the view 
	 */
	public void setView(View view){
		this.view = view;
		
	}
	


}
