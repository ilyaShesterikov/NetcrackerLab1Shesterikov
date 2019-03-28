package analyzer;

import fillers.Fill;
import fillers.Filler;
import org.junit.Test;
import output.Output;
import sorters.AbstractSorter;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AnalyzeUsingReflactionTest {

    @Test(timeout = 500)
    public void analyze() {
        int arraySize = 1000;
        Reflaction reflaction = new Reflaction();
        for(Method fillMethod : reflaction.getAnnotadedMethods(Fill.class, Filler.class)) {
            for (Class cl: reflaction.getClasses(AbstractSorter.class.getClassLoader(),"sorters")) {
                AnalyzeUsingReflaction a = new AnalyzeUsingReflaction();
                int[] expected = a.makeArray(fillMethod, arraySize);
                int[] actual = expected.clone();
                a.analyze(expected, cl);
                Arrays.sort(actual);
                assertArrayEquals(expected, actual);
            }
        }
    }

    @Test(timeout = 500)
    public void makeArray() {
        int arraySize = 1000;
        AnalyzeUsingReflaction a = new AnalyzeUsingReflaction();
        Reflaction reflaction = new Reflaction();
        for(Method fillMethod : reflaction.getAnnotadedMethods(Fill.class, Filler.class)) {
            a.makeArray(fillMethod, arraySize);
        }
    }
}