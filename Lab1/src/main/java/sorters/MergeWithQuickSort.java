package sorters;

public class MergeWithQuickSort extends MergeSorter {
    public void sort(int[] array) {
        QuickSort s = new QuickSort();
        mergeSort(s, array, 0, array.length - 1);
    }
}
