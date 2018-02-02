package graph;

import java.util.Arrays;

public class KruskalMST extends Graph {
	public KruskalMST(int length) {
		super(length);
	}

	public static void main(String[] args) {
		Graph g = getSampleGraph();
		KruskalMST g1 = new KruskalMST(g.edges.length);
		g1.kruskal(g);
		g1.printGraph();
	}

	private void kruskal(Graph g) {
		Arrays.sort(g.edges);
		int k = 0;
		for (int i = 0; i < g.edges.length; i++) {
			this.addEdge(k, g.edges[i]);
			if (!isCycle(this.edges)) {
				k++;
			} else {
				this.addEdge(k, null);
			}
		}
	}

	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	boolean isCycle(Edge[] edges) {
		int parent[] = new int[edges.length];
		for (int i = 0; i < edges.length; ++i)
			parent[i] = -1;
		for (int i = 0; i < edges.length; ++i) {
			if (edges[i] != null) {
				int x = find(parent, edges[i].src);
				int y = find(parent, edges[i].dest);
				if (x == y)
					return true;
				Union(parent, x, y);
			}
		}
		return false;
	}
}
