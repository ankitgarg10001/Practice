package challenges.salseforce.May26_2021;

import java.util.Arrays;

public class MinStepsForSnakeAndLadders {

    public static void main(String[] args) {
        int[] input = {-1, 7, -1, -1, -1, -1, -1, 3, -1};

        final int[] optimizedValue = new int[input.length];
        Arrays.fill(optimizedValue, Integer.MAX_VALUE);
        int shortestCount = shortestCount(input, 0, Integer.MAX_VALUE, 0, optimizedValue, new boolean[input.length]);
        System.out.println(shortestCount);
    }

    private static int shortestCount(int[] input, int currentStep, int minStepsYet, int currentStepCount, int[] optimizedValue,
        boolean[] isStepVisited) {
        if (optimizedValue[currentStep] != Integer.MAX_VALUE) {
            return currentStepCount + optimizedValue[currentStep];
        }
        if (isStepVisited[currentStep]) {
            return minStepsYet;
        }
        if (currentStep <= input.length) {
            isStepVisited[currentStep] = true;
        }
        if (currentStep == input.length - 1) {
            return Math.min(currentStepCount, minStepsYet);
        }
        for (int i = 1; i <= Math.min(6, input.length - currentStep - 1); i++) {
            int nextStep = currentStep + i;
            if (input[nextStep] != -1) {
                nextStep = input[nextStep];
            }
            int result = shortestCount(input, nextStep, minStepsYet, currentStepCount + 1, optimizedValue, isStepVisited);
            minStepsYet = Math.min(minStepsYet, result);
        }
        isStepVisited[currentStep] = false;
        optimizedValue[currentStep] = Math.min(optimizedValue[currentStep], minStepsYet);
        return minStepsYet;
    }

}
