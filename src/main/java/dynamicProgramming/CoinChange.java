package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 10};
        int sumRequired = 20;
        System.out.printf("Number of ways to reach %s are %s%n", sumRequired, checkWaysRecursive(sumRequired, numbers, numbers.length - 1));
        sumRequired = 19;
        System.out.printf("Number of ways to reach %s are %s%n", sumRequired, checkWaysDP(sumRequired, numbers));
    }

    private static int checkWaysDP(int sumRequired, int[] numbers) {
        int[] solution = new int[sumRequired + 1];
        Arrays.fill(solution, 0);
        solution[0] = 1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers[i]; j <= sumRequired; j++) {
                solution[j] += solution[j - numbers[i]];
            }
        }
        return solution[sumRequired];

    }

    private static int checkWaysRecursive(int sumRequired, int[] numbers, int index) {
        if (sumRequired == 0) {
            return 1;
        }
        if (sumRequired < 0 || index < 0) {
            return 0;
        }
        return checkWaysRecursive(sumRequired - numbers[index], numbers, index) + checkWaysRecursive(sumRequired, numbers, index - 1);
    }
}
