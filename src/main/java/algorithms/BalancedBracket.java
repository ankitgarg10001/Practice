package algorithms;

import java.util.Stack;

public class BalancedBracket {
	public static void main(String[] args) {
		String[] input = { "{[]}", "{[}]" };
		input = braces(input);
		for (String a : input)
			System.out.println(a);
	}

	private static String[] braces(String[] values) {
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				values[i] = isbalanced(values[i]) ? "YES" : "NO";
			}
		}
		return values;
	}

	private static boolean isbalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (currentChar == '[' || currentChar == '(' || currentChar == '{') {
				stack.push(currentChar);
			} else if (currentChar == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (currentChar == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (currentChar == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

}
