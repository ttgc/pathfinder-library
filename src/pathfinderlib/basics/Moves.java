package pathfinderlib.basics;

import java.io.Serializable;

import pathfinderlib.exceptions.GeneratingMoveException;

/**
 * Enum types for moves items
 * @author ttgc
 * @version 1.0
 * @serial
 */
public enum Moves implements Serializable {
	Left(-1,0),
	Right(1,0),
	Up(0,-1),
	Down(0,1);
	
	private int dx;
	private int dy;
	
	/**
	 * Constructor
	 * @param dx
	 * @param dy
	 */
	Moves(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * @return the move on x axis (-1, 0 or 1)
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * @return the move on y axis (-1, 0 or 1)
	 */
	public int getDy() {
		return dy;
	}
	
	@Override
	public String toString() {
		return "("+dx+";"+dy+")";
	}
	
	/**
	 * Static method for getting a Moves object from a direction
	 * @param dx the x direction (should be -1, 0 or 1)
	 * @param dy the y direction (should be -1, 0 or 1)
	 * @return the Moves value corresponding to the direction given
	 * @throws GeneratingMoveException raised when the (dx;dy) values are not valid
	 */
	public static Moves getMoveFromDist(int dx, int dy) throws GeneratingMoveException {
		if (dx == 1 && dy == 0) {
			return Right;
		} else if (dx == -1 && dy == 0) {
			return Left;
		} else if (dx == 0 && dy == 1) {
			return Down;
		} else if (dx == 0 && dy == -1) {
			return Up;
		} else {
			throw new GeneratingMoveException("invalid dx and dy values : ("+dx+" ; "+dy+")");
		}
	}

}
