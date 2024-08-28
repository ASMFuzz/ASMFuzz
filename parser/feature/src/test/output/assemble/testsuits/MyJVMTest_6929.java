import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_6929 {

    static AnnotationValue av = null;

    static Object o = 7;

    String visit(AnnotationValue av, Object o) {
        return "visit";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6929().visit(av, o));
    }
}
