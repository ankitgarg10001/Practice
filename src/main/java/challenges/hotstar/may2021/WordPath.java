package challenges.hotstar.may2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Min hops required to reach fro work A to work B
 */
public class WordPath {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("TOON"/*, "SOON"*/, "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN");
        int minHops = findPath(dictionary, "TOON", "PLEA");
        System.out.println(minHops);
    }

    private static int findPath(List<String> dictionary, String start, String end) {
        if (start == null || end == null || start.length() != end.length()) {
            return 0;
        }
        int[][] graph = createGraph(dictionary, start);
        return findMinPath(graph, dictionary.indexOf(start), dictionary.indexOf(end));

    }

    private static int[][] createGraph(List<String> dictionary, String start) {
        boolean[] visited = new boolean[dictionary.size()];
        int[][] graph = new int[dictionary.size()][dictionary.size()];
        Queue<String> values = new LinkedList<>();
        visited[dictionary.indexOf(start)] = true;
        values.offer(start);
        while (!values.isEmpty()) {
            final String currentVal = values.poll();
            for (int i = 0; i < currentVal.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    final String newValue = currentVal.substring(0, i) + (char) ('A' + j) + currentVal.substring(i + 1);
                    if (newValue.equals(currentVal) || !dictionary.contains(newValue) || visited[dictionary.indexOf(newValue)]) {
                        continue;
                    }
                    visited[dictionary.indexOf(newValue)] = true;
                    graph[dictionary.indexOf(currentVal)][dictionary.indexOf(newValue)] = 1;
                    graph[dictionary.indexOf(newValue)][dictionary.indexOf(currentVal)] = 1;
                    values.offer(newValue);
                }
            }
        }
        return graph;
    }

    private static int findMinPath(int[][] graph, int start, int end) {
        //BFS from start to end
        Queue<Integer> values = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        values.offer(start);
        int count = 0;
        int currSize = values.size();
        while (!values.isEmpty()) {
            currSize--;
            if (currSize == 0) {
                count++;
            }
            final Integer currentVal = values.poll();
            if (currentVal == end) {
                return count;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[currentVal][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    values.offer(i);
                }
            }
            if (currSize == 0) {
                currSize = values.size();
            }
        }
        return 0;
    }

}
