package sorters;

public class MergeWithBubbleSortSink extends AbstractSorter {
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    void merge(int arr[], int l, int m, int r) {
        int k = l;
        int n1 = m - l + 1;
        int n2 =  r - m;
        int L[] = new int[n1 + n2];
        for (int i = 0; i < n1 + n2; i++)
            L[i] = arr[l + i];
        BubbleSortSink qs = new BubbleSortSink();
        qs.sort(L);
        for (int i = 0; i < n1 + n2; i++)
            arr[k + i]= L[i];
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = l+(r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
}
