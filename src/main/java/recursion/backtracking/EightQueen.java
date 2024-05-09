package recursion.backtracking;

public class EightQueen {
	int board[][];
	private int boardSize = 8;

	public static void main(String[] args) {
		EightQueen eightQueen = new EightQueen();
		eightQueen.initBoard();
		eightQueen.display();
		eightQueen.getSolution(0, 0);
		System.out.println("----------RepeatingElementsArray------------");
		eightQueen.display();
	}

	private boolean getSolution(int row, int count) {
		if (count == board.length)
			return true;
		if (row >= boardSize)
			return false;
		for (int i = 0; i < boardSize; i++) {
			if (isSafe(row, i)) {
				board[row][i] = 1;
				if (getSolution(row + 1, count + 1)) {
					return true;
				}
				board[row][i] = 0;
			}
		}
		return false;

	}

	private boolean isSafe(int row, int col) {
		for (int i = 0; i < boardSize; i++) {
			if (board[row][i] == 1)
				return false;
			if (board[i][col] == 1)
				return false;

		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i < boardSize && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i < boardSize && j < boardSize; i++, j++) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j < boardSize; i--, j++) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	private void display() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	private void initBoard() {
		board = new int[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = 0;

			}
		}
	}
}
