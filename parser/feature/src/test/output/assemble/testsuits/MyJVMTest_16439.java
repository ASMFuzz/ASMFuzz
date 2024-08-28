import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_16439 {

    static AnnotationValue av = null;

    static Object o = 0;

    String visit(AnnotationValue av, Object o) {
        return "visit";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16439().visit(av, o));
    }
}
