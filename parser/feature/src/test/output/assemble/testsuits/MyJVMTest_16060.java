import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import java.lang.annotation.Annotation;

public class MyJVMTest_16060 {

    static Class<A> annotationType = null;

    <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16060().getAnnotation(annotationType));
    }
}
