package recursion;

public class Fabonacci {

	public static void main(String[] args) {
		Fabonacci fabonacci = new Fabonacci();
		/*int requiredNumbers = 100;
		fabonacci.getFabonacci(requiredNumbers);
		System.out.println("----------------------------------");
		fabonacci.getFabonacciTillNumber(requiredNumbers);*/
		System.out.println(0);
		System.out.println(1);
		fabonacci.printFabonacci(0, 1, 10);
	}

	private void printFabonacci(int last, int last2, int count) {
		if (count < 0)
			return;
		last = last + last2;
		System.out.println(last);
		printFabonacci(last2, last, --count);
	}

	private void getFabonacciTillNumber(int requiredSum) {
		switch (requiredSum) {
		case 0:
			System.out.println("0");
			break;
		case 1:
		case 2:
			System.out.println("0");
			System.out.println("1");
			break;
		default:
			System.out.println("0");
			System.out.println("1");
			getNumbers(requiredSum, 1, 0, true);
			break;
		}
	}

	private void getFabonacci(int requiredNumbers) {
		switch (requiredNumbers) {
		case 0:

			break;
		case 1:
			System.out.println("0");
			break;
		case 2:
			System.out.println("1");
			break;
		default:
			System.out.println("0");
			System.out.println("1");
			getNumbers(requiredNumbers - 2, 1, 0, false);
			break;
		}
	}

	private void getNumbers(int requiredNumbers, int current, int previous, boolean isSum) {
		if (!isSum && requiredNumbers == 0) {
			return;
		} else if (isSum && requiredNumbers < current + previous)
			return;
		current = current + previous;
		previous = current - previous;
		System.out.println(current);
		if (!isSum)
			getNumbers(requiredNumbers - 1, current, previous, isSum);
		else
			getNumbers(requiredNumbers, current, previous, isSum);
	}
}
