package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubSets {
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<>();
		x.add(1);
		x.add(2);
		x.add(3);
		//		x.add(4);
		//		x.add(5);
		showSubSets(x);
		result.stream().forEach(System.out::println);
	}

	static Set<Set<Integer>> result = new HashSet<>();

	private static void showSubSets(ArrayList<Integer> set) {
		result.add(new HashSet<>(set));
		for (int i = 0; i < set.size(); i++) {
			int x = set.remove(i);
			result.add(new HashSet<>(Arrays.asList(x)));
			showSubSets(set);
			result.add(new HashSet<>(set));
			set.add(x);
		}
	}
}
