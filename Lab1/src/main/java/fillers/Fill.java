package fillers;
import java.lang.annotation.*;
import java.util.Random;

public class Fill {

    final static private int MAX_VALUE = 1000;
    final static private int INTERVAL = 5;

    @Filler
    public static int[] makeSortedArrayAsc(int n) {
        Random r = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(INTERVAL) + i * INTERVAL;
        }

        return result;
    }

    @Filler
    public static int[] makeSortedArrayDesc(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[n - i - 1] = r.nextInt(INTERVAL) + i * INTERVAL;
        }
        return result;
    }

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
