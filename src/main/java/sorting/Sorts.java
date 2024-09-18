package sorting;

import java.util.Arrays;
import java.util.Random;

public abstract class Sorts {

    protected static Integer[] getJumbledArray(int i) {
        return new Random()
            .ints(0, 100)
            .limit(10)
            .boxed()
            .toArray(Integer[]::new);
    }

    protected void printArray(Integer[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public abstract void sort(Integer[] arr);

}
