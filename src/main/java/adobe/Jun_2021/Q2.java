package adobe.Jun_2021;

/**
 * Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.
 * You may return any answer array that satisfies this condition.
 */
public class Q2 {

    public static void main(String[] args) {
        int[] input = {3, 1, 2, 4};
        reShuffle(input);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    private static void reShuffle(int[] input) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            if (input[left] % 2 == 0) {
                left++;
            } else if (input[right] % 2 == 1) {
                right--;
            } else {
                swap(input, left, right);
                left++;
                right--;
            }
        }
    }

    private static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
