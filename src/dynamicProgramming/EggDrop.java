package dynamicProgramming;


import java.util.Arrays;

public class EggDrop {

    public static int[][] arr;

    /* Function to get minimum number of
    trials needed in worst case with n
    eggs and k floors */
    static int eggDrop(int n, int k) {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if(arr[n][k]!=-1) return arr[n][k];
        if (k == 1 || k == 0) {
            arr[n][k]=k;
            return k;
        }

        // We need k trials for one egg
        // and k floors
        if (n == 1) {
            arr[n][k]=k;
            return k;
        }

        arr[n][k] = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from
        // 1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1),
                eggDrop(n, k - x)) + 1;
            if (res < arr[n][k]) {
                arr[n][k] = res;
            }
        }

        return arr[n][k];
    }

    // Driver code
    public static void main(String args[]) {
        int n = 2, k = 100;

        arr = new int[n+1][k+1];
        for (int currArr[] : arr) {
            Arrays.fill(currArr, -1);
        }
        System.out.print("Minimum number of "
            + "trials in worst case with "
            + n + " eggs and " + k
            + " floors is " + eggDrop(n, k));
    }
    // This code is contributed by Ryuga.
}
