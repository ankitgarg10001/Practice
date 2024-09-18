package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * RepeatingElementsArray Exists of all middle words exists in dictionary
 * @author Ankit.Garg
 *
 */

public class TransformWord {

	public static void main(String[] args) {
		String startWord = "DAMP";
		String endWord = "LIKE";
		Set<String> dictionary = new HashSet<>();
		dictionary.add("DAMP");
		dictionary.add("DAME");
		dictionary.add("LAMP");
		dictionary.add("LIME");
		dictionary.add("LAME");
		dictionary.add("LIKE");
		if (transform(startWord, endWord, dictionary)) {
			System.out.println("RepeatingElementsArray Found");
		} else
			System.out.println("No RepeatingElementsArray Found");
	}

	private static boolean transform(String startWord, String endWord, Set<String> dictionary) {
		if (!dictionary.contains(startWord)) {
			return false;
		}
		if (startWord.equals(endWord)) {
			System.out.print(startWord + " <- ");
			return true;
		}
		for (int i = 0; i < startWord.length(); i++) {
			if (startWord.charAt(i) != endWord.charAt(i)) {
				if (transform(startWord.substring(0, i) + endWord.charAt(i) + startWord.substring(i + 1), endWord,
						dictionary)) {
					System.out.print(startWord + " <- ");
					return true;
				}
			}
		}
		return false;
	}
}
