package analyzer;

import fillers.*;
import sorters.AbstractSorter;
import sorters.QuickSort;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReflactionsAnalyze {

    public static void main(String[] args) {
        ReflactionsAnalyze ra = new ReflactionsAnalyze();
        try {
            ra.analyze(1000);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void analyze (int n) throws InvocationTargetException, IllegalAccessException {
        Method[] fillMethods = Fill.class.getMethods();
        for(Method fillMethod : fillMethods) {
            if (fillMethod.isAnnotationPresent(Filler.class)) {
                for (Class cl: getClasses(QuickSort.class.getClassLoader(),"sorters")) {
                    if( Modifier.isPublic( cl.getModifiers() )) {

                        int[] array = (int[]) fillMethod.invoke(Fill.class, n);
                        Method sortMethod = null;
                        try {
                            sortMethod = cl.getMethod("sort");
                            long time = countTime(sortMethod, cl, array);
                            System.out.println("FillType: " + fillMethod.getName() + "\tSortType: " + cl.getName() + "\t" + time);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    public static List<Class> getClasses(ClassLoader cl, String pack){

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource(pack);

        DataInputStream dis = null;
        try {
            dis = new DataInputStream((InputStream) upackage.getContent());

        String line = null;
        while ((line = dis.readLine()) != null) {
            if(line.endsWith(".class")) {
                classes.add(Class.forName(dottedPackage + "." + line.substring(0, line.lastIndexOf('.'))));
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }

    private long countTime(Method m, Class cl, int[] array){
        long countTime = System.nanoTime();
        try {
            m.invoke(cl, array);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        countTime = System.nanoTime() - countTime;
        return countTime;
    }
}
