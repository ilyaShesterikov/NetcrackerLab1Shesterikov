package analyzer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Reflaction {

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


}
