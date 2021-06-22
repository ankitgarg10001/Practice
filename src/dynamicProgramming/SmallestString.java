package dynamicProgramming;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

class Result {

    static BigInteger[] weights = new BigInteger[26];

    public static void initialize() {
        weights[0] = BigInteger.valueOf(1l);
        for (int i = 1; i < weights.length; i++) {
            weights[i] = weights[i - 1].add((weights[i - 1].multiply(BigInteger.valueOf(i + 1))));
        }
//        for (BigInteger weight : weights) {
//            System.out.print(weight.toString() + ",");
//        }
    }

    /*
     * Complete the 'smallestString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER weight as parameter.
     */

    public static String smallestString(long weight) {
        // Write your code here
        String result = findList(BigInteger.valueOf(weight), "");
        assert result != null;
        char[] charResult = result.toCharArray();
        Arrays.sort(charResult);
        return new String(charResult);
    }

    public static String findList(BigInteger weight, String result) {
        if (weight.compareTo(BigInteger.ZERO) == 0) {
            return result;
        } else if (weight.compareTo(BigInteger.ZERO) < 0) {
            return null;
        } else {
            long minSoFar = Long.MAX_VALUE;
            String resultSoFar = null;
            for (int i = weights.length - 1; i >= 0; i--) {
                if (weights[i].compareTo(weight) > 0) {
                    continue;
                }
                String adding = findList(weight.subtract(weights[i]), result + ((char) ('A' + i)));
                if (adding != null && adding.length() < minSoFar) {
                    minSoFar = adding.length();
                    resultSoFar = adding;
                }
            }
            return resultSoFar;
        }
    }

}

public class SmallestString {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Result.initialize();
        long weight = 27;

        String result = Result.smallestString(weight);
        System.out.println("\n\n" + result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
