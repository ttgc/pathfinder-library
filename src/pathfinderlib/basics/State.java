package pathfinderlib.basics;

import java.io.Serializable;

/**
 * State enum used to precised wich item is an obstacle or not
 * @author ttgc
 * @version 1.0
 * @serial
 */
public enum State implements Serializable {
	Void,
	Obstacle;
	
}
