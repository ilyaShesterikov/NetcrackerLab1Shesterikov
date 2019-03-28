package sorters;


import analyzer.Analyze;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeWithQuickSortTest {
    @Test(timeout = 500)
    public void sort() {
        int arraySize = 1000;
        for(Analyze.FillType ft: Analyze.FillType.values()){
            Analyze a = new Analyze();
            int[] expected = a.makeArray(ft, arraySize);
            int[] actual = expected.clone();
            MergeWithQuickSort s = new MergeWithQuickSort();
            s.sort(expected);
            Arrays.sort(actual);
            assertArrayEquals(expected, actual);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        MergeWithQuickSort s = new MergeWithQuickSort();
        s.sort(null);
    }
}
