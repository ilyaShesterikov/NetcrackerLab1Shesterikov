package fillers;
import java.lang.annotation.*;
import java.util.Random;

/**
 * Arrays can be generated in 4 ways
 * (ascending order, descending order, ascending order with random element in the end, random order).
 * Class Fill gives opportunity to fill array with this methods
 *
 * @author Shesterikov
 */
public class Fill {

    final static private int MAX_VALUE = 1000;
    final static private int INTERVAL = 5;

    /**
     * Generates array of ints in ascending order
     * @param n size of array
     * @return generated array of ints
     */
    @Filler
    public static int[] makeSortedArrayAsc(int n) {
        Random r = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(INTERVAL) + i * INTERVAL;
        }

        return result;
    }

    /**
     * Generates array of ints in descending order
     * @param n size of array
     * @return generated array of ints
     */
    @Filler
    public static int[] makeSortedArrayDesc(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[n - i - 1] = r.nextInt(INTERVAL) + i * INTERVAL;
        }
        return result;
    }

    /**
     * Generates array of ints in ascending order with random element in the end
     * @param n size of array
     * @return generated array of ints
     */
    @Filler
    public static int[] makeSortedArrayAscX(int n) {
        Random r = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n-1; i++) {
            result[i] = r.nextInt(INTERVAL) + i * INTERVAL;
        }
        result[n - 1] = r.nextInt(n * INTERVAL);
        return result;
    }

    /**
     * Generates array of ints in random order
     * @param n size of array
     * @return generated array of ints
     */
    @Filler
    public static int[] makeArray(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(MAX_VALUE);
        }
        return result;
    }
}
