package analyzer;

import fillers.Fill;
import fillers.Filler;
import sorters.AbstractSorter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalyzeUsingReflaction {

    public static void main(String[] args) {
        AnalyzeUsingReflaction aur = new AnalyzeUsingReflaction();
        try {
            aur.analyze(1000);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void analyze (int n) throws InvocationTargetException, IllegalAccessException {
        Method[] fillMethods = Fill.class.getMethods();
        Reflaction ref = new Reflaction();

        for(Method fillMethod : fillMethods) {
            if (fillMethod.isAnnotationPresent(Filler.class)) {
                for (Class cl: ref.getClasses(AbstractSorter.class.getClassLoader(),"sorters")) {
                        int[] array = (int[]) fillMethod.invoke(Fill.class, n);
                        Method sortMethod = null;
                        try {
                            sortMethod = cl.getMethod("sort", int[].class );
                            long time = countTime(sortMethod, cl, array);
                            //System.out.println("FillType: " + fillMethod.getName()
                           //         + "\tSortType: " + cl.getName() + "\t" + time);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                }
            }
        }
    }

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
