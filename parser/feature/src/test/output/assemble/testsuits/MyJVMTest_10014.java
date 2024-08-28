import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_10014 {

    static NullType t = null;

    static Object o = 7;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitNull(NullType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10014().visitNull(t, o));
    }
}
