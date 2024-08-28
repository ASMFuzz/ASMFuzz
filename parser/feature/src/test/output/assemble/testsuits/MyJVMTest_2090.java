import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_2090 {

    static TypeVariable t = null;

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitTypeVariable(TypeVariable t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2090().visitTypeVariable(t, o));
    }
}
