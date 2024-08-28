import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_12283 {

    static TypeMirror t = null;

    static Object o = 9;

    String visit(TypeMirror t, Object o) {
        return "visit";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12283().visit(t, o));
    }
}
