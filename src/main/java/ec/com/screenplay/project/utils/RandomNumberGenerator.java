package ec.com.screenplay.project.utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int MIN = 1;
    private static final int MAX = 6;

    // Constructor privado para evitar la instanciación
    private RandomNumberGenerator() {
        throw new AssertionError("You can't instantiate the class RandomNumberGenerator.");
    }

    public static int[] generateUniqueRandomNumbers() {
        int num1, num2;

        do {
            num1 = RANDOM.nextInt(MAX - MIN + 1) + MIN;
            num2 = RANDOM.nextInt(MAX - MIN + 1) + MIN;
        } while (num1 == num2);

        return new int[]{num1, num2};
    }
}
