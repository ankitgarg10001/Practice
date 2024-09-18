package challenges.expedia.May2021;

import java.util.Arrays;
import java.util.List;

// Min Jumps required to get difference between min and max values >= threshold
// can jump at n+1 or N+2
// start from 0
public class MinJumps {

    public static void main(String[] args) {
        int threshold = 402;
        List<Integer> points = Arrays.asList(
            162,
            206,
            224,
            264,
            288,
            334,
            364,
            367,
            389,
            405,
            454,
            478,
            479,
            482,
            509,
            517,
            545,
            578,
            626,
            657,
            692,
            705,
            720,
            734,
            747
        );
        System.out.println(minNum(threshold, points));
    }

    public static int minNum(int threshold, List<Integer> points) {
        int min = points.get(0);
        int[] results = new int[points.size()];
        Arrays.fill(results, -1);
        return minNum(threshold, points, min, min, 0, 1, results);
    }

    private static int minNum(int threshold, List<Integer> points, int min, int max, int currentIndex, int currentCount, int[] results) {
        if (max - min >= threshold) {
//            System.out.printf("Found result at %d hops%n", currentCount);
            return currentCount;
        }
        if (currentCount >= points.size()) {
            return points.size();
        }
        if (results[currentIndex] != -1) {
            return results[currentIndex];
        }
        int resultPlus2 = currentIndex + 2 < points.size() ?
            minNum(threshold, points, Math.min(min, points.get(currentIndex + 2)), Math.max(max, points.get(currentIndex + 2)),
                currentIndex + 2, currentCount + 1, results) : points.size();
        int resultPlus1 = currentIndex + 1 < points.size() ?
            minNum(threshold, points, Math.min(min, points.get(currentIndex + 1)), Math.max(max, points.get(currentIndex + 1)),
                currentIndex + 1, currentCount + 1, results) : points.size();
        return results[currentIndex] = Math.min(resultPlus1, resultPlus2);
    }
}
