package recursion.backtracking;

public class RatInAMaze {

	public static void main(String[] args) {
		int maze[][] = { { 0, 0, 0, -1, -1 }, { 0, 0, -1, 0, -1 }, { -1, 0, -1, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, -1, -1, 0, 0 } };
		display(maze);
		RatInAMaze ratInAMaze = new RatInAMaze();
		if (!ratInAMaze.solve(0, 0, maze))
			System.out.println("No RepeatingElementsArray Found");
		else
			System.out.println("Solved!!!");
		display(maze);
	}

	private boolean solve(int xIndex, int yIndex, int[][] maze) {
		if (maze[xIndex][yIndex] != 0) {
			return false;
		}

		maze[xIndex][yIndex] = 1;

		if (xIndex == maze.length - 1 && yIndex == maze[xIndex].length - 1) {
			return true;
		}
		boolean solution = false;
		if (xIndex < maze.length - 1) {
			solution = solve(xIndex + 1, yIndex, maze);
		}
		if (!solution && yIndex < maze[xIndex].length - 1) {
			solution = solve(xIndex, yIndex + 1, maze);
		}
		if (!solution)
			maze[xIndex][yIndex] = 0;
		return solution;

	}

	private static void display(int[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == -1)
					System.out.print(maze[i][j] + " ");
				else
					System.out.print(" " + maze[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
