package algorithms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatingElementsArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		printRepeating(arr);
	}

	static void printRepeating(int arr[]) {
		int i;
		System.out.println("The repeating elements are: \n");
		for (i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

	private void test() {
		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		Map<String, Integer> sorted = budget.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

	}
}
