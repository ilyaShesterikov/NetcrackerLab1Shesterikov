package sorters;

public class BubbleSortSink extends BubbleSorter {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n - i - 1; j++){
                checkAndSwap(array, j);
            }
        }
    }
}