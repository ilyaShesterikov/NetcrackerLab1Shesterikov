package analyzer;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test(timeout = 500)
    public void analyze() {
        int arraySize = 1000;
        for(Analyze.FillType ft: Analyze.FillType.values()){
            for (Analyze.SortType st : Analyze.SortType.values()) {
                Analyze a = new Analyze();
                int[] expected = a.makeArray(ft, arraySize);
                int[] actual = expected.clone();
                a.analyze(expected, st);
                Arrays.sort(actual);
                assertArrayEquals(expected, actual);
            }
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        Analyze a = new Analyze();
        a.analyze(null, null);
    }
}
