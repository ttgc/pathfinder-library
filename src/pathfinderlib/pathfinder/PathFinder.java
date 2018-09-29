package pathfinderlib.pathfinder;

import java.awt.Point;
import java.util.Collections;
import java.util.Vector;

import pathfinderlib.basics.Matrix;
import pathfinderlib.basics.Moves;
import pathfinderlib.basics.State;
import pathfinderlib.exceptions.GeneratingMoveException;
import pathfinderlib.exceptions.PathfindingException;

/**
 * PathFinder object allow to search the shortest path on a map between 2 points.
 * The Map should be represented (or converted) as a 2D grid.
 * Creating the object won't automatically search the right path, you should use method searchPath to do it
 * @author thomas
 * @version 1.0
 */
public class PathFinder {
	private Matrix<State> graph;
	private Node start;
	private Node end;

	/**
	 * Create the PathFinder item and configure it for the search
	 * @param laby a Matrix representing the map and its obstacles
	 * @param start the start point
	 * @param end the end point
	 */
	public PathFinder(Matrix<State> laby, Point start, Point end) {
		// TODO Auto-generated constructor stub
		this.graph = laby.submatrix(laby.getWidth(), laby.getHeight());
		this.start = new Node(start.x, start.y);
		this.end = new Node(end.x, end.y);
	}
	
	/**
	 * Search the shortest path between start and end point
	 * @return The list of Moves to reach the end point
	 * @throws PathfindingException raised when no path exists between the 2 points
	 */
	public Vector<Moves> searchPath() throws PathfindingException {
		Matrix<Node> grid = new Matrix<>(graph.getWidth(), graph.getHeight());
		for (int i=0;i<grid.getWidth();i++) {
			for (int k=0;k<grid.getHeight();k++) {
				grid.set(i, k, new Node(i, k));
			}
		}
		grid.set(start.x, start.y, start);
		grid.set(end.x, end.y, end);
		Vector<Node> closedList = new Vector<Node>();
		Vector<Node> openList = new Vector<Node>();
		openList.add(start);
		while (!openList.isEmpty()) {
			openList.sort(null);
			Node u = openList.remove(openList.size()-1);
			if (u.x == end.x && u.y == end.y) {
				end = u;
				return getPath();
			}
			for (int i=0;i<4;i++) {
				Node v = getNeighbour(grid, u, i);
				if (graph.get(v.x, v.y).equals(State.Obstacle)) {
					continue;
				}
				if (((!checkNodeIn(closedList, v)) || checkNodeCout(closedList, v)) && ((!checkNodeIn(openList, v)) || checkNodeCout(openList, v))) {
					v.cout = u.cout+1;
					Point vec = new Point(end.x-v.x, end.y-v.y);
					v.heuristique = v.cout + Math.sqrt((vec.x * vec.x) + (vec.y * vec.y));
					if (checkNodeIn(openList, v)) {
						removeNode(openList, v);
					}
					openList.add(new Node(v));
					openList.lastElement().parent = u;
				}
			}
			closedList.add(new Node(u));
		}
		throw new PathfindingException("empty openlist. Probably there is no path");
	}
	
	private Vector<Moves> getPath() throws PathfindingException {
		Vector<Moves> path = new Vector<Moves>();
		Vector<Node> nodes = new Vector<Node>();
		nodes.add(end);
		while (nodes.lastElement().parent != null) {
			nodes.add(nodes.lastElement().parent);
		}
		Collections.reverse(nodes);
		Node cur = start;
		for (Node i : nodes) {
			int dx = i.x - cur.x;
			int dy = i.y - cur.y;
			try {
				path.add(Moves.getMoveFromDist(dx, dy));
				cur = i;
			} catch (GeneratingMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return path;
	}

	private Node getNeighbour(Matrix<Node> grid, Node cur, int index) throws PathfindingException {
		switch(index) {
		case 0:
			return grid.get(cur.x-1, cur.y);
		case 1:
			return grid.get(cur.x, cur.y-1);
		case 2:
			return grid.get(cur.x+1, cur.y);
		case 3:
			return grid.get(cur.x, cur.y+1);
		default:
			throw new PathfindingException("getNeighbour error : index "+index+" is not valid");
		}
	}
	
	private boolean checkNodeIn(Vector<Node> ls, Node nd) {
		for (Node i : ls) {
			if (i.x == nd.x && i.y == nd.y) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkNodeCout(Vector<Node> ls, Node nd) {
		for (Node i : ls) {
			if (i.x == nd.x && i.y == nd.y) {
				return i.cout >= nd.cout;
			}
		}
		return false;
	}
	
	private void removeNode(Vector<Node> ls, Node nd) {
		for (Node i : ls) {
			if (i.x == nd.x && i.y == nd.y) {
				ls.remove(i);
				return;
			}
		}
	}

}
