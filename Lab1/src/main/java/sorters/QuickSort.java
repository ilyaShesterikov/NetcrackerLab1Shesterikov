package sorters;

/**
 * Class of quick sort for array of ints
 * @author Shesterikov
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Wikipedia: Quick sort</a>
 */
public class QuickSort extends AbstractSorter {

    /**
     * Sorts the specified array of ints in ascending order
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Split and sort recursively array with quick sort
     *
     * @param array array of ints needed to sort
     * @param low first element of part
     * @param high last element of part
     */
    private void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

}
