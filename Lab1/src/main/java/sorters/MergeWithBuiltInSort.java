package sorters;

public class MergeWithBuiltInSort extends MergeSorter{
    public void sort(int[] array) {
        BuiltInSort s = new BuiltInSort();
        mergeSort(s, array, 0, array.length - 1);
    }
}
