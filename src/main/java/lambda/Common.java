package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Common {
	String[] alphabets = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" };
	String alpha = "abcdefghijklmnopqrstuvwxyz";

	Stream<Double> random = Stream.generate(Math::random);

	private ArrayList<String> getTempList() {
		ArrayList<String> listToBeSorted = new ArrayList<>();
		Random rnd = new Random();
		rnd.setSeed(alphabets.length);
		while (listToBeSorted.size() != alphabets.length - 1) {
			String selectedchar = alphabets[rnd.nextInt(alphabets.length)];
			if (!listToBeSorted.contains(selectedchar)) {
				listToBeSorted.add(selectedchar);
			}
		}
		return listToBeSorted;

	}

	private Integer getRandomNumber(int length) {
		return random.findAny().orElse(1.0).intValue() % length - 1;
	}

	private ArrayList<String> getJumbeledList() {
		List<String> listToBeSorted = Arrays.asList(alphabets);
		for (int i = 0; i < 100; i++) {
			listToBeSorted.add(alpha.substring(getRandomNumber(alpha.length()), getRandomNumber(alpha.length())));

		}
		Collections.shuffle(listToBeSorted);
		return new ArrayList<>(listToBeSorted);

	}

	private ArrayList<String> comparableDemo(ArrayList<String> listToBeSorted) {
		BiFunction<String, String, Integer> biFunction = (first, second) -> first.compareTo(second);
		Collections.sort(listToBeSorted, (first, second) -> first.compareTo(second));
		return listToBeSorted;
	}

	public static void main(String[] args) throws InterruptedException {
		// Common may_6 = new Common();
		// ArrayList<String> tempList = may_6.getJumbeledList();
		// showList(tempList);
		// showList(may_6.comparableDemo(tempList));

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(1);

			}
		});

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(2);

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(3);

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(4);

			}
		});
		t.start();
		t.join();
		t2.start();
		t.join();
		t1.start();
		t3.start();
		t.join();

		// TreeSet<Integer> t = new TreeSet<>();
		// t.add(1);
		// t.add(4);
		// t.add(3);
		// t.add(2);
		// t.add(5);
		// System.out.println(t);

	}

	private static void showList(ArrayList<String> tempList) {
		tempList.forEach(System.out::print);/*
											 * for (String entity : tempList) entity->System.out::print(entity+" ");
											 */
		System.out.println("");
		System.out.println("================================");
	}

}
