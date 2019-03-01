package sorters;

/**
 * Class of bubble sort with floating up element for array of ints
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia: Bubble sort</a>
 */
public class BubbleSortFloatUp extends BubbleSorter {

    /**
     * Sorts the specified array of ints in ascending order
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++){
            for (int j = n - 1; j > i; j--){
                checkAndSwap(array, j-1);
            }
        }
    }
}