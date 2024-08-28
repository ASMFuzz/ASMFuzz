import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_11336 {

    static TypeVariable t = null;

    static Object o = 6;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitTypeVariable(TypeVariable t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11336().visitTypeVariable(t, o));
    }
}
