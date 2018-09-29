package pathfinderlib.pathfinder;

/**
 * Node item represents points objects with a cost and distance notion.
 * this is used to represents a full map and to calculate the shortest path between two points.
 * This class can also be used as standard points
 * 
 * <i>implements Comparable for comparing Node between them</i>
 * @author ttgc
 * @version 1.0
 */
public class Node implements Comparable<Node> {
	protected int x;
	protected int y;
	protected int cout;
	protected double heuristique;
	protected Node parent;

	
	/**
	 * Basic constructor, create a Node for coordinates (0;0)
	 */
	public Node() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
		cout = 0;
		heuristique = 0;
	}
	
	/**
	 * Create a Node at precised coordinates
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		cout = 0;
		heuristique = 0;
	}
	
	/**
	 * Clone a Node object
	 * @param other the Node that should be cloned
	 */
	public Node(Node other) {
		x = other.x;
		y = other.y;
		cout = other.cout;
		heuristique = other.heuristique;
		parent = other.parent;
	}

	@Override
	public int compareTo(Node other) {
		// TODO Auto-generated method stub
		if (heuristique < other.heuristique) {
			return 1;
		} else if (heuristique == other.heuristique) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * @return the x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the cost to reach this Node
	 */
	public int getCout() {
		return cout;
	}

	/**
	 * @return the true distance to reach this Node
	 */
	public double getHeuristique() {
		return heuristique;
	}

}
