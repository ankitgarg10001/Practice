package dynamicProgramming;

public class FindMountain {

    public static void main(String[] args) {
        int[] arr = {2, 1/*, 4, 7, 3, 2, 5,6,5,4,3,2,1*/};
        int result = findMaxMountainLength(arr);
        System.out.println(result);
    }

    private static int findMaxMountainLength(int[] arr) {
        int result = 0;
        int uphill = 0;
        int downhill = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (downhill > 0) {
                    //found another mountain, maybe
                    result = Math.max(result, uphill + downhill + 1);
                    downhill = 0;
                    uphill = 0;
                }
                ++uphill;
            } else if (uphill > 0) {
                ++downhill;
            }
        }
        if (uphill > 0 && downhill > 0) {
            result = Math.max(result, uphill + downhill + 1);
        }
        return result;
    }
}
