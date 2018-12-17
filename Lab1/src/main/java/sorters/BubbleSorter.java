package sorters;

public abstract class BubbleSorter extends AbstractSorter {
    protected void checkAndSwap(int[] array, int firstPosition){
        if (array[firstPosition] > array[firstPosition+1]) {
            int temp = array[firstPosition];
            array[firstPosition] = array[firstPosition+1];
            array[firstPosition+1] = temp;
        }
    }
}
