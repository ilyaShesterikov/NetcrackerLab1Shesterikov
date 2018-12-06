package sorters;

public class MergeWithBubbleSortFloatUp extends MergeSorter {
    public void sort(int[] array) {
        BubbleSortFloatUp s = new BubbleSortFloatUp();
        mergeSort(s, array, 0, array.length - 1);
    }
}
