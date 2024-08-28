import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_4754 {

    static TypeMirror t = null;

    static Object o = 9;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitUnknown(TypeMirror t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4754().visitUnknown(t, o));
    }
}
