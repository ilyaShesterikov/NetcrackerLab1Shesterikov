package sorters;

/**
 * Class Mergesort contains methods to split array and call sorters
 * Parent class of classes: <ul>
 *     <li>{@link MergeWithBubbleSortFloatUp}  </li>
 *     <li>{@link MergeWithBubbleSortSink}  </li>
 *     <li>{@link MergeWithBuiltInSort}  </li>
 *     <li>{@link MergeWithQuickSort}  </li>
 *     </ul>
 * @author Shesterikov
 */
 class MergeSorter extends AbstractSorter{

    /**
     * Sort the specified part of array
     *
     * @param s sorter
     * @param arr array of ints needed to sort
     * @param l first element of part
     * @param m medium element of part
     * @param r last element of part
     *
     * @see sorters.BubbleSortFloatUp
     * @see sorters.BubbleSortSink
     * @see sorters.BuiltInSort
     * @see sorters.QuickSort
     * @see sorters.MergeWithBubbleSortFloatUp
     * @see sorters.MergeWithBubbleSortSink
     * @see sorters.MergeWithBuiltInSort
     * @see sorters.MergeWithQuickSort
     */
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

    /**
     * Splits array into equal parts
     *
     * @param s sorter
     * @param arr array of ints needed to sort
     * @param l first element of part
     * @param r last element of part
     *
     * @see sorters.BubbleSortFloatUp
     * @see sorters.BubbleSortSink
     * @see sorters.BuiltInSort
     * @see sorters.QuickSort
     * @see sorters.MergeWithBubbleSortFloatUp
     * @see sorters.MergeWithBubbleSortSink
     * @see sorters.MergeWithBuiltInSort
     * @see sorters.MergeWithQuickSort
     */
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

    /**
     * Takes an array and merge sorts it in parallel if there
     * are multiple threads
     *
     * @param arr is the array to sort
     * @param from is the first value to sort
     * @param to is the last value to sort
     * @param availableThreads is how many threads there are to utilize
     */
    public void parallelMergeSort(final AbstractSorter s, final int arr[], final int from, final int to, final int availableThreads){
        if (to - from > 0){
            if (availableThreads <=1) {
                mergeSort(s, arr, from, to);
            }
            else {
                final int middle = to/2;

                Thread firstHalf = new Thread(){
                    public void run(){
                         parallelMergeSort(s, arr, from, middle, availableThreads - 1);
                    }
                };
                Thread secondHalf = new Thread(){
                    public void run(){
                          parallelMergeSort(s, arr, middle + 1, to, availableThreads - 1);
                    }
                };

                firstHalf.start();
                secondHalf.start();

                try {
                    firstHalf.join();
                    secondHalf.join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

                merge(s, arr, from, middle, to);
            }
        }
    }

    public void sort(int[] array) {

    }
}