package Assignment;

// Question Number 5(a)

import java.util.Random;

public class HillClimbing {

    private static final int MAX_ITERATIONS = 1000;
    private static final double STEP_SIZE = 0.1;

    // The objective function to maximize (can be replaced with any function)
    private static double objectiveFunction(double x) {
        return -1 * x * x + 5 * x + 10;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Start with a random initial solution
        double currentSolution = random.nextDouble() * 10;
        double currentValue = objectiveFunction(currentSolution);

        int iterations = 0;
        while (iterations < MAX_ITERATIONS) {
            // Generate a random neighbor within the specified step size
            double neighborSolution = currentSolution + (random.nextDouble() - 0.5) * STEP_SIZE;
            double neighborValue = objectiveFunction(neighborSolution);

            // If the neighbor has a higher value, move to that neighbor
            if (neighborValue > currentValue) {
                currentSolution = neighborSolution;
                currentValue = neighborValue;
            }

            iterations++;
        }

        System.out.println("Best Solution: " + currentSolution);
        System.out.println("Best Value: " + currentValue);
    }
}
