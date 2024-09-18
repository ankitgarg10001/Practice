package graph;

public class Edge implements Comparable<Edge> {

	int weight;
	int src, dest;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge arg0) {
		return weight - arg0.weight;
	}

	@Override
	public String toString() {
		return src + "<---" + weight + "--->" + dest;
	}
}
