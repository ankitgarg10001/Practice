package challenges.expedia.May2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/largest-area-possible-after-removal-of-a-series-of-horizontal-vertical-bars/
public class MaxBoxAfterRemovingLines {

    public static void main(String[] args) {
        System.out.println(prison1(3, 2, Arrays.asList(1, 2, 3), Arrays.asList(1, 2)));
    }

    public static long prison1(int N, int M, List<Integer> H, List<Integer> V) {
        int maxHorizontal = findMaxConsecutive(H);
        int maxVertical = findMaxConsecutive(V);
        return (long) (maxHorizontal + 1) * (maxVertical + 1);
    }

    public static int findMaxConsecutive(List<Integer> list) {
        list.sort(Integer::compareTo);
        int previous = list.get(0);
        int count = 1;
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            int temp=list.get(i);
            if (temp == previous + 1) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 1;
            }
            previous=temp;
        }
        result = Math.max(count, result);
        return result;
    }

    public static long prison(int N, int M, List<Integer> H, List<Integer> V) {
        List<Integer> s1 = IntStream.rangeClosed(0, N + 1)
            .boxed().collect(Collectors.toList());
        List<Integer> s2 = IntStream.rangeClosed(0, M + 1)
            .boxed().collect(Collectors.toList());
        s1.removeAll(H);
        s2.removeAll(V);

        Integer[] horizontalBars = s1.toArray(new Integer[0]);
        Integer[] verticalBars = s2.toArray(new Integer[0]);

        return (long) findMaxDiff(horizontalBars) * findMaxDiff(verticalBars);

    }

    private static int findMaxDiff(Integer[] bars) {
        int max = 0;
        int temp = 0;
        for (int horizontalBar : bars) {
            max = Math.max(max, horizontalBar - temp);
            temp = horizontalBar;
        }
        return max;
    }

}
