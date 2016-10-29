package position;

import java.io.Serializable;


/** 
 *The Class define a common  functionality general position
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-30-07
 */
public abstract class AbstractPosition  implements PositionInterface,Serializable {
	

	private static final long serialVersionUID = -4283147570582017755L;

	
	public abstract String toString();
	
	
	@Override
	public abstract boolean equals(Object obj);


}
