package analyzer;

import fillers.Fill;
import fillers.Filler;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to do all needed work with reflection
 * @author Shesterikov
 */
public class Reflaction {

    /**
     * Returns all classes {@link java.lang.Class} in the specified package
     *
     * @param cl classloader of any class in the specified package
     * @param pack package name
     * @return all classes in the certain package
     * @see java.lang.ClassLoader
     */
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
                Class c = Class.forName(dottedPackage + "." + line.substring(0, line.lastIndexOf('.')));
                if( !Modifier.isAbstract( c.getModifiers() )) {
                    classes.add(c);
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }


    /**
     * Returns all methods {@link java.lang.reflect.Method} in the specified class
     *
     * @param className name of the class
     * @param annotation annotation
     * @return all methods annotaded in the specified class
     */
    public static List<Method> getAnnotadedMethods(Class className, Class annotation){
        List<Method> annotadedMethods = new ArrayList<Method>();
        Method[] fillMethods = className.getMethods();
        for(Method fillMethod : fillMethods) {
            if (fillMethod.isAnnotationPresent(Filler.class)) {
                annotadedMethods.add(fillMethod);
            }
        }
        return annotadedMethods;
    }


}
