package sorters;

import java.util.Arrays;

/**
 * Class of built in sort for array of ints
 * @author Shesterikov
 */
public class BuiltInSort extends AbstractSorter {

    /**
     * Sorts the specified array of ints in ascending order
     * @param array array of ints needed to sort
     */
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
