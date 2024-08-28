import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_10537 {

    static AnnotatedElementDelegate delegate = null;

    int testNullHandling(AnnotatedElementDelegate delegate) {
        int failures = 0;
        try {
            Object result = delegate.getDeclaredAnnotationsByType(null);
            failures++;
        } catch (NullPointerException npe) {
            ;
        }
        try {
            Object result = delegate.getAnnotationsByType(null);
            failures++;
        } catch (NullPointerException npe) {
            ;
        }
        try {
            Object result = delegate.getDeclaredAnnotation(null);
            failures++;
        } catch (NullPointerException npe) {
            ;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10537().testNullHandling(delegate));
    }
}
