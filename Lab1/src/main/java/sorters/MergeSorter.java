package sorters;

public abstract class MergeSorter extends AbstractSorter{
    void merge(AbstractSorter s, int arr[], int l, int m, int r) {
        int k = l;
        int n1 = m - l + 1;
        int n2 =  r - m;
        int L[] = new int[n1 + n2];
        for (int i = 0; i < n1 + n2; i++)
            L[i] = arr[l + i];
        s.sort(L);
        for (int i = 0; i < n1 + n2; i++)
            arr[k + i]= L[i];
    }

    void mergeSort(AbstractSorter s, int arr[], int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = l+(r-l)/2;

            // Sort first and second halves
            mergeSort(s, arr, l, m);
            mergeSort(s, arr, m+1, r);
            merge(s, arr, l, m, r);
        }
    }
}
