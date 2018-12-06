package sorters;

public class MergeWithBubbleSortSink extends MergeSorter {
    public void sort(int[] array) {
        BubbleSortSink s = new BubbleSortSink();
        mergeSort(s, array, 0, array.length - 1);
    }
}
