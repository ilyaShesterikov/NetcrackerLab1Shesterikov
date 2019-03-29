package sorters;

/**
 * Class of built in sort with merging for array of ints
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia: Bubble sort</a>
 */
public class MergeWithBuiltInSort extends MergeSorter{
    /**
     * Uses MergeSorter {@link MergeSorter} to sort the specified array with BuiltInSort {@link BuiltInSort}
     * method in ascending order.
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        BuiltInSort s = new BuiltInSort();
        MergeSorter mergeSorter = new MergeSorter();
        mergeSorter.parallelMergeSort(s, array, 0, array.length - 1, Runtime.getRuntime().availableProcessors());
        //mergeSort(s, array, 0, array.length - 1);
    }
}
