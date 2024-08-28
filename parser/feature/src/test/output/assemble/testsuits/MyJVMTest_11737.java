import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_11737 {

    static ErrorType t = null;

    static Object o = 2016525255;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitError(ErrorType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11737().visitError(t, o));
    }
}
