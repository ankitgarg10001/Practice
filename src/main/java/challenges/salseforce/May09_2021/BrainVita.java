package challenges.salseforce.May09_2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * BELOW CODE DOES NOT WORK, YET!!! BrainVita is a game, similar to SUDOKU
 * <pre>
 *   111
 *   111
 * 1111111
 * 1110111
 * 1111111
 *   111
 *   111
 * </pre>
 * each marble can jump over another marble if it's final position is empty. also, each marble can only jump 1 marble at max
 */
public class BrainVita {

    static class Coordinates {

        int row, col;

        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                "row=" + row +
                ", row=" + col +
                "} ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Coordinates)) {
                return false;
            }
            Coordinates that = (Coordinates) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) {
        Integer[][] input = new Integer[7][7];
        for (Integer[] a : input) {
            Arrays.fill(a, 1);
        }
        input[3][3] = 0;
        final LinkedList<Coordinates> visited = new LinkedList<>();
        visited.add(new Coordinates(3, 3));
        final boolean result = BrainVita.solve(input, visited);
        if (result) {
            System.out.println("Solved");
            for (Integer[] a : input) {
                for (int i : a) {
                    System.out.print(i + "  ");
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Not Solved");
            for (Integer[] a : input) {
                for (int i : a) {
                    System.out.print(i + "  ");
                }
                System.out.println("\n");
            }
        }

    }

    private static boolean solve(Integer[][] input, LinkedList<Coordinates> visited) {
        visited.forEach(System.out::print);
        System.out.println("\n");
        if (visited.size() == 32) {
            return true;
        }
        for (int i = 0; i < visited.size(); i++) {
            Coordinates coordinate = visited.removeFirst();
            final Coordinates nextCoordinate_row = new Coordinates(coordinate.row + 1, coordinate.col);
            final Coordinates nextToNextCoordinate_row = new Coordinates(coordinate.row + 2, coordinate.col);
            final Coordinates prevCoordinate_row = new Coordinates(coordinate.row - 1, coordinate.col);
            final Coordinates prevToPrevCoordinate_Row = new Coordinates(coordinate.row - 2, coordinate.col);
            final Coordinates nextCoordinate_col = new Coordinates(coordinate.row, coordinate.col + 1);
            final Coordinates nextToNextCoordinate_col = new Coordinates(coordinate.row, coordinate.col + 2);
            final Coordinates prevCoordinate_col = new Coordinates(coordinate.row, coordinate.col - 1);
            final Coordinates prevToPrevCoordinate_col = new Coordinates(coordinate.row, coordinate.col - 2);

            if (checkForSolutionRecursive(input, coordinate, nextCoordinate_row, nextToNextCoordinate_row, new LinkedList<>(visited))) {
                return true;
            } else if (checkForSolutionRecursive(input, coordinate, prevCoordinate_row, prevToPrevCoordinate_Row,
                new LinkedList<>(visited))) {
                return true;
            } else if (checkForSolutionRecursive(input, coordinate, nextCoordinate_col, nextToNextCoordinate_col,
                new LinkedList<>(visited))) {
                return true;
            } else if (checkForSolutionRecursive(input, coordinate, prevCoordinate_col, prevToPrevCoordinate_col,
                new LinkedList<>(visited))) {
                return true;
            }

            visited.addLast(coordinate);
        }
        return false;
    }

    private static boolean checkForSolutionRecursive(Integer[][] input, Coordinates originalCoordinate, Coordinates nextCoordinate,
        Coordinates nextToNextCoordinate, LinkedList<Coordinates> visited) {
        if (inbounds(input, nextCoordinate.row, nextCoordinate.col) && inbounds(input, nextToNextCoordinate.row,
            nextToNextCoordinate.col)) {
            input[originalCoordinate.row][originalCoordinate.col] = 1;
            input[nextCoordinate.row][nextCoordinate.col] = 0;
            input[nextToNextCoordinate.row][nextToNextCoordinate.col] = 0;
            visited.addLast(nextCoordinate);
            if (solve(input, visited)) {
                return true;
            }
            visited.remove(nextCoordinate);
            visited.addLast(nextToNextCoordinate);

            if (solve(input, visited)) {
                return true;
            }
            visited.remove(nextToNextCoordinate);
            input[originalCoordinate.row][originalCoordinate.col] = 0;
            input[nextCoordinate.row][nextCoordinate.col] = 1;
            input[nextToNextCoordinate.row][nextToNextCoordinate.col] = 1;
        }
        return false;
    }

    public static boolean inbounds(Integer[][] input, int x, int y) {
        if (x < 2 || x > 5 || y < 2 || y > 5) {
            return false;
        }
        return input[x][y] == 1;
    }
}
