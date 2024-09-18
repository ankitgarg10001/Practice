package challenges.salseforce.May09_2021;

import java.util.Arrays;
import java.util.List;

/**
 * Find max length travelable, to get unique set of values. if we start from a[k], next value to travel is a[a[k]], and so on till we are
 * out of bounds or repeating
 */
public class ZeroIndexedArray {

    public static void main(String[] args) {
        int result = doit(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)); //2
        System.out.println(result);
        result = doit(Arrays.asList(5, 4, 3, 1, 6, 2)); //6
        System.out.println(result);
        result = doit(Arrays.asList(5, 4, 0, 3, 1, 6, 2, 8, 9, 2, 1, 34)); //6
        System.out.println(result);
        result = doit(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)); //1
        System.out.println(result);
        result = doit(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)); //1
        System.out.println(result);
        result = doit(Arrays.asList(5, 4, 0, 3, 1, 6, 2)); //4
        System.out.println(result);
    }

    public static int doit(List<Integer> arr) {
        System.out.println(arr);
        int result = 0;
        for (int i = 0; i < arr.size(); i++) {
            boolean[] visited = new boolean[arr.size()]; //can be above result if values are unique in array
            if (visited[i]) {
                continue;
            }
            int currentCount = 0;
            int previousIndex = i;
            int nextIndex = -1;
            do {
                nextIndex = arr.get(previousIndex);
                ++currentCount;
                visited[previousIndex] = true;
                if (nextIndex >= arr.size() || nextIndex < 0) {
                    break;
                }
                if (previousIndex == nextIndex) {
                    currentCount--; //for case of repeated characters like 1,1
                }
                previousIndex = nextIndex;
            } while (!visited[previousIndex]);

            result = Math.max(result, currentCount);
        }
        return result;
    }

}
