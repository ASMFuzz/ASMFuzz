import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_11537 {

    static T[] delegate = { false, true, true, true, true, true, false, false, true, false };

    static Class<? extends Annotation> annotationClass = null;

    static String message = "(er6=+>ix[";

    static AnnotatedElement base = null;

    <T extends Annotation> int annotationArrayCheck(T[] delegate, T[] base, Class<? extends Annotation> annotationClass, String message) {
        int failures = 0;
        if (!Objects.deepEquals(delegate, base)) {
            failures = 1;
            System.err.printf(message, annotationClass, delegate);
            System.err.println("Base result:\t" + Arrays.toString(base));
            System.err.println("Delegate result:\t " + Arrays.toString(delegate));
            System.err.println();
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11537().annotationArrayCheck(delegate, base, annotationClass, message));
    }
}
