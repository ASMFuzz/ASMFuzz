import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3931 {

    static TypeMirror t = null;

    static Object o = 1390630051;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitType(TypeMirror t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3931().visitType(t, o));
    }
}
