package analyzer;

import fillers.Fill;
import fillers.Filler;
import sorters.AbstractSorter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * CClass analyzer to call all fillers {@link fillers.Fill} and sort methods {@link sorters}
 * using reflection {@link Reflaction} and count time of sorting.
 * @author Shesterikov
 */
public class AnalyzeUsingReflaction {

    /**
     *
     * @param n size of array
     * @param sorterClass sorter class {@link sorters}
     * @param fillMethod fill method {@link fillers.Fill}
     * @return
     */
    public long analyze (int n, Class sorterClass, Method fillMethod)  {
        int[] array;
        long time = 0;
        try {
            array = (int[]) fillMethod.invoke(Fill.class, n);
            Method sortMethod = null;
            sortMethod = sorterClass.getMethod("sort", int[].class );
            time = countTime(sortMethod, sorterClass, array);
            System.out.println("FillType: " + fillMethod.getName()
                    + "\tSortType: " + sorterClass.getName() + "\t" + time);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * Counts time of sorting
     * @param m filler method
     * @param cl sorter class
     * @param array array to be sorted
     * @return time of sorting in nanoseconds
     */
    private long countTime(Method m, Class cl, int[] array){
        long countTime = System.nanoTime();
        try {
            m.invoke(cl.newInstance(), array);
            for(int i : array) System.out.print(" " +i);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        countTime = System.nanoTime() - countTime;
        return countTime;
    }
}
