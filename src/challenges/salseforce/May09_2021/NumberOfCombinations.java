package challenges.salseforce.May09_2021;

/**
 * <pre>
 *  A=1, B=2,C=3...Z=26
 *  Find number of combinations that can be created by a number, given a number that actually has one combination
 *  like 1226 has ABBF, ABZ, LZ, LBF, AVF ->5
 *  like 101 has JA only ->1
 *  like 123 has ABC, LC, AW ->3
 * </pre>
 */
public class NumberOfCombinations {

    public static int doit(String num, boolean[] isValidString) {
        if (num.length() == 0 || isValidString[num.length()]) {
            isValidString[num.length()] = true;
            return 1;
        }
        if (num.charAt(0) == '0') {
            isValidString[num.length()] = false;
            return 0;
        }
        if (num.length() > 1 && Integer.parseInt(num.substring(0, 2)) <= 26) {
            final int result = doit(num.substring(1), new boolean[num.length()]) + doit(num.substring(2), new boolean[num.length()]);
            isValidString[num.length()] = (result != 0);
            return result;
        } else {
            final int result = doit(num.substring(1), new boolean[num.length()]);
            isValidString[num.length()] = (result != 0);
            return result;
        }

    }

    public static void main(String[] args) {
        callWithInput("1226");
        callWithInput("101");
        callWithInput("123");
        callWithInput("204");
    }

    private static void callWithInput(String num) {
        final int result = NumberOfCombinations.doit(num, new boolean[num.length() + 1]);
        System.out.printf("result for %s is %d%n", num, result);
    }
}
