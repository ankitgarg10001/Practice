package graph;

public class Graph {
	final Edge[] edges;

	public Graph() {
		edges = null;
	}

	public Graph(int edgesCount) {
		edges = new Edge[edgesCount];
	}

	protected void addEdge(int edgeNumber, Edge edge) {
		edges[edgeNumber] = edge;
	}

	protected void printGraph() {
		if (edges != null) {
			for (int i = 0; i < edges.length; i++) {
				if (edges[i] != null)
					System.out.println(edges[i]);
			}
		}
	}

	public static Graph getSampleGraph() {
		Graph graph = new Graph(5);
		graph.addEdge(0, new Edge(0, 1, 10));
		graph.addEdge(1, new Edge(1, 3, 15));
		graph.addEdge(2, new Edge(3, 2, 4));
		graph.addEdge(3, new Edge(0, 2, 6));
		graph.addEdge(4, new Edge(0, 3, 5));
		return graph;
	}
}
