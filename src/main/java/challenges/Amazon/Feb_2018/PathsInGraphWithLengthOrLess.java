package challenges.Amazon.Feb_2018;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

//import for Scanner and other utility  classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class PathsInGraphWithLengthOrLess {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 * Use either of these methods for input
		
		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		//Scanner
		*/
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			int K = s.nextInt();
			for (int j = 0; j < N; j++) {
				int u = s.nextInt();
			}
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
			for (int j = 0; j < N - 1; j++) {
				int u = s.nextInt();
				int v = s.nextInt();
				ArrayList<Integer> arr = graph.get(u);
				if (arr == null) {
					arr = new ArrayList<>();
					graph.put(u, arr);
				}
				arr.add(v);
			}
			System.out.println("Case "+(i+1)+": "+(checkNumberOfPaths(graph, K - 1, 0) + N));
		}
		s.close();
	}

	private static int checkNumberOfPaths(HashMap<Integer, ArrayList<Integer>> graph, int K, int sum) {
		if (K <= 0)
			return sum;
		Iterator<Entry<Integer, ArrayList<Integer>>> iterator = graph.entrySet().iterator();
		while (iterator.hasNext()) {
			for (Integer currentNode : iterator.next().getValue()) {
				sum = checkNumberOfPathsForNode(graph, K - 1, sum + 1, currentNode);
			}
		}
		return sum;
	}

	private static int checkNumberOfPathsForNode(HashMap<Integer, ArrayList<Integer>> graph, int K, int sum,
			Integer currentNode) {
		if (K <= 0)
			return sum;
		ArrayList<Integer> arr = graph.get(currentNode);

		if (arr != null) {
			for (Integer currentNode1 : arr) {
				sum = checkNumberOfPathsForNode(graph, K - 1, sum + 1, currentNode1);
			}
		}
		return sum;
	}
}
