package sorters;


/**
 * Parent class of {@link BubbleSortFloatUp} and {@link BubbleSortSink}
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia: Bubble sort</a>
 */
public abstract class BubbleSorter extends AbstractSorter {

    /**
     * Checks if two elements stand in ascending order. Otherwise, swaps them.
     * @param array
     * @param firstPosition
     */
    protected void checkAndSwap(int[] array, int firstPosition){
        if (array[firstPosition] > array[firstPosition+1]) {
            int temp = array[firstPosition];
            array[firstPosition] = array[firstPosition+1];
            array[firstPosition+1] = temp;
        }
    }
}
