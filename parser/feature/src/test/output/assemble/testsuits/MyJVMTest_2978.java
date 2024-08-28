import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_2978 {

    static TypeMirror t = null;

    static Object o = 7;

    String visit(TypeMirror t, Object o) {
        return "visit";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2978().visit(t, o));
    }
}
