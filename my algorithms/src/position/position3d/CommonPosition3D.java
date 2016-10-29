package position.position3d;

import position.AbstractPosition;


/** 
 *The Class define a common functionality general position3D
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class CommonPosition3D extends AbstractPosition{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6489677062288421443L;


	@Override
	public abstract String toString();


	@Override
	public abstract boolean equals(Object obj);


}
