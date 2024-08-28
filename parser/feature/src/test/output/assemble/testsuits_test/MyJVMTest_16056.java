import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import java.lang.annotation.Annotation;
import java.util.List;

public class MyJVMTest_16056 {

    List<? extends AnnotationMirror> getAnnotationMirrors() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16056().getAnnotationMirrors());
    }
}
