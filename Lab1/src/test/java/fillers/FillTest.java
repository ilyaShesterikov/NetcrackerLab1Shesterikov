package fillers;

import org.junit.Test;

import static org.junit.Assert.*;

public class FillTest {

    @Test(timeout = 500)
    public void makeSortedArrayAsc() {
        int arraySize = 10;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayAsc(arraySize);
    }

    @Test(timeout = 500)
    public void makeSortedArrayDesc() {
        int arraySize = 10;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayDesc(arraySize);
    }

    @Test(timeout = 500)
    public void makeSortedArrayAscX() {
        int arraySize = 10;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayAscX(arraySize);
    }

    @Test(timeout = 500)
    public void makeArray() {
        int arraySize = 10;
        Fill f = new Fill();
        int[] expected = f.makeArray(arraySize);
    }

    @Test(expected = OutOfMemoryError.class)
    public void makeArrayTestOutOfMemoryExeption() {
        int arraySize = 600000000;
        Fill f = new Fill();
        int[] expected = f.makeArray(arraySize);
    }

    @Test(expected = OutOfMemoryError.class)
    public void makeSortedArrayAscTestOutOfMemoryExeption() {
        int arraySize = 600000000;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayAsc(arraySize);
    }

    @Test(expected = OutOfMemoryError.class)
    public void makeSortedArrayDescTestOutOfMemoryExeption() {
        int arraySize = 600000000;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayDesc(arraySize);
    }

    @Test(expected = OutOfMemoryError.class)
    public void makeSortedArrayAscXTestOutOfMemoryExeption() {
        int arraySize = 600000000;
        Fill f = new Fill();
        int[] expected = f.makeSortedArrayAscX(arraySize);
    }
}