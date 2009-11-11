import java.awt.* ;
import java.util.* ;

public class Graph {
	private HashMap<Point,Vector<Point>> adj ;

	public Graph() {
		adj = new HashMap<Point,Vector<Point>>() ;
	}

	public void addPoint(Point p) {
		adj.put(p,new Vector<Point>()) ;
	}

	public void addPoints(Point[] points) {
		for(Point p : points) {
			adj.put(p,new Vector<Point>()) ;
		}
	}

	public void connect(Point a, Point b) {
		adj.get(a).add(b) ;
		adj.get(b).add(a) ;
	}
	
	public boolean isConnected (Point a, Point b) {
		return adj.get(a).contains(b) ;
	}

	public Set<Point> getPoints() {
		return adj.keySet() ;
	}

	public java.util.List<Point> getConnections(Point p) {
		return adj.get(p) ;
	}
}
