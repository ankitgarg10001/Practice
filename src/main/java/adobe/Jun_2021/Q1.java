package adobe.Jun_2021;

/**
 * [2:37 pm] Ankit Bhandari (Guest) Given an encoded string, return its decoded string.
 *
 * Input - 3[a]2[bc] OutPut - aaabcbc
 *
 * Input - 3[a2[c]] Output - accaccacc
 *
 * Input - 10[ab] Output - abababababababababab
 *
 * Input - xy2[abc]3[cd]ef Output - xyabcabccdcdcdef
 */
public class Q1 {

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        String result = solve(input);
        System.out.printf("Result of %s is %s%n", input, result);
        input = "3[a2[c]]";
        result = solve(input);
        System.out.printf("Result of %s is %s%n", input, result);
        input = "10[ab]";
        result = solve(input);
        System.out.printf("Result of %s is %s%n", input, result);
        input = "xy2[abc]3[cd]ef";
        result = solve(input);
        System.out.printf("Result of %s is %s%n", input, result);
    }

    private static String solve(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            i = solveRecursively(input, i, result, 0);
        }
        return result.toString();
    }

    private static int solveRecursively(String input, int startIndex, StringBuilder finalResult, int repeatCount) {
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                int number = getNumberBefore(input, i);
                i = solveRecursively(input, i + 1, result, number);
            } else if (input.charAt(i) == ']') {
                for (int j = 0; j < repeatCount; j++) {
                    finalResult.append(result);
                }
                return i;
            } else if (!Character.isDigit(input.charAt(i))) {
                result.append(input.charAt(i));
            }
        }
        finalResult.append(result);
        return input.length();
    }

    private static int getNumberBefore(String input, int endIndex) {
        StringBuilder result = new StringBuilder();
        for (int i = endIndex - 1; i >= 0; i--) {
            if (Character.isDigit(input.charAt(i))) {
                result.append(input.charAt(i));
            } else {
                break;
            }
        }
        return Integer.parseInt(result.reverse().toString());
    }
}
