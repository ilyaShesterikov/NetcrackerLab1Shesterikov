package sorters;

public class BubbleSortFloatUp extends BubbleSorter {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= i + 1; j--){
                if (array[j] < array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }
}
