package sorters;

public class BubbleSortFloatUp extends BubbleSorter {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++){
            for (int j = n - 1; j > i; j--){
                checkAndSwap(array, j-1);
            }
        }
    }
}