package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
	public Node(int start) {
		this.startPos = start;
	}

	int startPos;
	Set<Integer> edges = new HashSet<>();
}

class GraphCyclicCheckGraph {
	List<Node> nodes = new ArrayList<>();
	Set<Integer> nodeList = new HashSet<>();

	public void addEdge(int start, int end) {
		Node currentNode = getNode(start, true);
		currentNode.edges.add(end);
		nodeList.add(start);
		nodeList.add(end);
	}

	private Node getNode(int start, boolean createNew) {
		for (Node node : nodes) {
			if (node.startPos == start)
				return node;
		}
		if (!createNew)
			return null;
		Node node = new Node(start);
		nodes.add(node);
		return node;
	}

	public void printGraph() {
		for (Node node : nodes) {
			System.out.print(node.startPos + " : ");
			for (Integer i : node.edges) {
				System.out.print(i + "  ");
			}
			System.out.println("");
		}
	}

	public void checkCycle() {
		boolean cycleFound = false;

		for (Node node : nodes) {
			boolean visited[] = new boolean[nodeList.size()];
			cycleFound = checkSubCycle(node, visited);
			if (cycleFound) {
				System.out.println("loop found from nde " + node.startPos);
				for (boolean b : visited) {
					System.out.print(b + " ");
				}
				return;
			}
		}
		System.out.println("No loop found");
	}

	private boolean checkSubCycle(Node node, boolean[] visited) {
		if (node == null)
			return false;
		if (visited[node.startPos]) {
			return true;
		}
		boolean cycleFound = false;
		visited[node.startPos] = true;
		for (Integer vertex : node.edges) {
			cycleFound = checkSubCycle(getNode(vertex, false), visited);
			if (cycleFound)
				return cycleFound;
		}
		if (!cycleFound)
			visited[node.startPos] = false;
		return cycleFound;
	}
}

public class GraphCyclicCheck {

	public static void main(String[] args) {
		GraphCyclicCheckGraph g = new GraphCyclicCheckGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		// g.addEdge(1, 2);
		// g.addEdge(2, 0);
		g.addEdge(2, 3);
		// g.addEdge(3, 3);
		g.printGraph();
		g.checkCycle();
	}
}
