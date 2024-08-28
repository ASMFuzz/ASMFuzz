import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_13236 {

    static NoType t = null;

    static Object o = 1;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitNoType(NoType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13236().visitNoType(t, o));
    }
}
