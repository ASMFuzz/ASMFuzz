import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_13002 {

    static TypeParameterElement e = null;

    static Object o = 2;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitTypeParameter(TypeParameterElement e, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13002().visitTypeParameter(e, o));
    }
}
