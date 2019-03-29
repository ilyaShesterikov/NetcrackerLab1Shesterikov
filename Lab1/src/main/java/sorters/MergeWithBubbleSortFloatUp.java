package sorters;

/**
 * Class of bubble sort with floating up element with merging for array of ints
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia: Bubble sort</a>
 */
public class MergeWithBubbleSortFloatUp extends MergeSorter{
    /**
     * Uses MergeSorter {@link MergeSorter} to sort the specified array with BubbleSortFloatUp {@link BubbleSortFloatUp}
     * method in ascending order.
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        BubbleSortFloatUp s = new BubbleSortFloatUp();
        MergeSorter mergeSorter = new MergeSorter();
        mergeSorter.parallelMergeSort(s, array, 0, array.length - 1, Runtime.getRuntime().availableProcessors());
    }
}
