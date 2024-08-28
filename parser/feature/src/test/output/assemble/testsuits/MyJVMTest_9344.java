import java.lang.reflect.*;
import java.io.*;
import javax.tools.*;

public class MyJVMTest_9344 {

    static Class<?> subClass = null;

    static Class<?> superClass = null;

    static StandardJavaFileManager delegate = null;

    Method checkAllMethodsOverridenInWrapperClass(Class<?> subClass, Class<?> superClass) {
        Method[] allMethods = subClass.getMethods();
        for (Method m : allMethods) {
            if (m.getDeclaringClass() == superClass) {
                throw new AssertionError(String.format("method %s not overriden by javac provided wrapper class", m.getName()));
            }
        }
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9344().checkAllMethodsOverridenInWrapperClass(subClass, superClass);
    }
}
