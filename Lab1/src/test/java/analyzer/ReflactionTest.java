package analyzer;

import fillers.*;
import org.junit.Assert;
import org.junit.Test;
import output.Output;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReflactionTest {

    @Test(timeout = 500)
    public void getClassesOfFillers() {
        Reflaction reflaction = new Reflaction();
        List expected = reflaction.getClasses(Fill.class.getClassLoader(),"fillers");
        List actual = new ArrayList();
        actual.add(Fill.class);

        assertEquals(expected, actual);
    }

    @Test(timeout = 500)
    public void getClassesOfOutput() {
        Reflaction reflaction = new Reflaction();
        List expected = reflaction.getClasses(Output.class.getClassLoader(),"output");
        List actual = new ArrayList();
        actual.add(Output.class);

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testPassingNullPackage() {
        Reflaction reflaction = new Reflaction();
        reflaction.getClasses(Reflaction.class.getClassLoader(),null);
    }

    @Test(timeout = 500)
    public void getAnnotadedMethods() {
        Reflaction reflaction = new Reflaction();
        List expected = reflaction.getAnnotadedMethods(Fill.class, Filler.class);
        List actual = new ArrayList();
        //actual.add();
        // как добавить вручную отдельный метод в List actual ?

        //assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testPassingNullClass() {
        Reflaction reflaction = new Reflaction();
        reflaction.getAnnotadedMethods(null,null);
    }
}