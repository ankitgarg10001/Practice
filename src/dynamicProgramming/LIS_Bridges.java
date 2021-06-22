package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
 */
public class LIS_Bridges {

    static class CityPair {

        int north, south;

        public CityPair(int north, int south) {
            this.north = north;
            this.south = south;
        }

        @Override
        public String toString() {
            return "CityPair{" +
                "north=" + north +
                ", south=" + south +
                '}';
        }
    }

    public static void main(String[] args) {
        List<CityPair> cities = new ArrayList<>();
        cities.add(new CityPair(6, 2));
        cities.add(new CityPair(4, 3));
        cities.add(new CityPair(1, 5));
        cities.add(new CityPair(2, 6));
        cities.sort((a, b) -> {
            if (a.south == b.south) {
                return Integer.compare(b.north, a.north);
            } else if (a.south < b.south) {
                return -1;
            } else {
                return 1;
            }
        });
        cities.forEach(System.out::println);
        System.out.println("Max number of bridges allowed are " + lis(cities));

    }

    /**
     * check longest increasing for north only as south is already sorted in increasing
     */
    private static int lis(List<CityPair> cities) {
        int[] sol = new int[cities.size()];
        Arrays.fill(sol, 1);
        for (int i = 1; i < cities.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (cities.get(i).north >= cities.get(j).north && sol[i] < sol[j] + 1) {
                    sol[i] = sol[j] + 1;
                }
            }
        }
        Arrays.stream(sol).forEach(System.out::print);
        return Arrays.stream(sol).max().getAsInt();
    }

}
