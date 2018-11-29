package fillers;
import java.util.Random;

public class Fill {
    public int[] makeSortedArrayAsc(int n) {
        Random r = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(5) + i * 5;
        }

        return result;
    }

    public int[] makeSortedArrayDesc(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[n - i - 1] = r.nextInt(5) + i * 5;
        }
        return result;
    }

    public int[] makeSortedArrayAscX(int n) {
        Random r = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n-1; i++) {
            result[i] = r.nextInt(5) + i * 5;
        }
        result[n - 1] = r.nextInt(n * 5);
        return result;
    }

    public int[] makeArray(int n) {
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = r.nextInt(1000);
        }
        return result;
    }
}
