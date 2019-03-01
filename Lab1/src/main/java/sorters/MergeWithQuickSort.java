package sorters;

/**
 * Class of quick sort with merging for array of ints
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Wikipedia: Quick sort</a>
 */
public class MergeWithQuickSort extends MergeSorter {
    /**
     * Uses MergeSorter {@link MergeSorter} to sort the specified array with QuickSort {@link QuickSort}
     * method in ascending order.
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        QuickSort s = new QuickSort();
        mergeSort(s, array, 0, array.length - 1);
    }
}
