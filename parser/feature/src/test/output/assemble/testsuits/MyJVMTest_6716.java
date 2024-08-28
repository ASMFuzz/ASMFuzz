import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import java.lang.annotation.Annotation;
import java.util.Arrays;

public class MyJVMTest_6716 {

    static Class<A> annotationType = null;

    <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6716().getAnnotationsByType(annotationType)));
    }
}
