package sorters;

public class BubbleSortFloatUp extends BubbleSorter {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j > i; j--){
                if (array[j-1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
