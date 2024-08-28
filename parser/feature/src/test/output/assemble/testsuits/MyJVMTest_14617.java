import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_14617 {

    static Class<?> clazz = null;

    static boolean annotationsExpectedOnMethods = true;

    static int errors = 0;

    AnnotatedType testGetAnnotations(Class<?> clazz, boolean annotationsExpectedOnMethods) {
        System.err.println("Testing getAnnotations on methods of class " + clazz.getName());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Type type = m.getGenericReturnType();
            AnnotatedType annotType = m.getAnnotatedReturnType();
            Annotation[] annotations = annotType.getAnnotations();
            boolean isVoid = "void".equals(type.toString());
            if (annotationsExpectedOnMethods && !isVoid) {
                if (annotations.length == 0) {
                    errors++;
                    System.err.println("Expected annotations missing on " + annotType);
                }
            } else {
                if (annotations.length > 0) {
                    errors++;
                    System.err.println("Unexpected annotations present on " + annotType);
                }
            }
        }
        return annotType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14617().testGetAnnotations(clazz, annotationsExpectedOnMethods);
    }
}
