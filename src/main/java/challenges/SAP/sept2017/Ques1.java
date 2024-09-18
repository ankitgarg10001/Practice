package challenges.SAP.sept2017;

import java.util.Arrays;

public class Ques1 {
	public static void main(String[] args) {
		Ques1 q = new Ques1();
		int[] a = { 1, 2, 4, 2, 1 };
		int[] b = { 3, 4, 5, 3, 2 };
		int[] c = { 5, 1, 7, 2, 5 };
		System.out.println(Arrays.toString(q.rangeofcost(5, 5, a, b, c, 1)));
	}

	public int[] rangeofcost(int input1, int input2, int[] input3, int[] input4, int[] input5, int input6) {
		int graph[][] = new int[input1][input1];
		for (int i = 0; i < input1; i++) {
			for (int j = 0; j < input1; j++) {
				graph[i][j] = 0;
			}
		}
		for (int i = 0; i < input3.length; i++) {
			graph[input3[i] - 1][input4[i] - 1] = input5[i];
			graph[input4[i] - 1][input3[i] - 1] = input5[i];
		}
		return new int[] { primMST(graph, true), primMST(graph, false) };
	}

	int printMST(int parent[], int n, int graph[][]) {
		int sum = 0;
		for (int i = 1; i < graph.length; i++)
			sum += graph[i][parent[i]];
		return sum;
	}

	int primMST(int graph[][], boolean isMin) {
		int parent[] = new int[graph.length];

		int key[] = new int[graph.length];

		Boolean mstSet[] = new Boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			key[i] = isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < graph.length - 1; count++) {
			int u = isMin ? minKey(key, mstSet, graph.length) : maxKey(key, mstSet, graph.length);
			mstSet[u] = true;

			for (int v = 0; v < graph.length; v++)

				if (graph[u][v] != 0 && mstSet[v] == false && (isMin ? graph[u][v] < key[v] : graph[u][v] > key[v])) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		return printMST(parent, graph.length, graph);
	}

	private int maxKey(int[] key, Boolean[] mstSet, int length) {
		int max = Integer.MIN_VALUE, max_index = -1;
		for (int v = 0; v < length; v++)
			if (mstSet[v] == false && key[v] > max) {
				max = key[v];
				max_index = v;
			}

		return max_index;
	}

	int minKey(int key[], Boolean mstSet[], int length) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < length; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}
}
