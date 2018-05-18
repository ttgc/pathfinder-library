package pathfinderlib.basics;

import java.io.Serializable;

import pathfinderlib.exceptions.GeneratingMoveException;

public enum Moves implements Serializable {
	Left(-1,0),
	Right(1,0),
	Up(0,-1),
	Down(0,1);
	
	private int dx;
	private int dy;
	
	Moves(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
	@Override
	public String toString() {
		return "("+dx+";"+dy+")";
	}
	
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
