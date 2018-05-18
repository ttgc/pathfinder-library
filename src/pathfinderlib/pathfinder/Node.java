package pathfinderlib.pathfinder;

public class Node implements Comparable<Node> {
	protected int x;
	protected int y;
	protected int cout;
	protected double heuristique;
	protected Node parent;

	public Node() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
		cout = 0;
		heuristique = 0;
	}
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		cout = 0;
		heuristique = 0;
	}
	
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCout() {
		return cout;
	}

	public double getHeuristique() {
		return heuristique;
	}

}
