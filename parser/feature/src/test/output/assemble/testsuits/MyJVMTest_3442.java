import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3442 {

    static AnnotationValue av = null;

    static Object o = -837021752;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitUnknown(AnnotationValue av, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3442().visitUnknown(av, o));
    }
}
