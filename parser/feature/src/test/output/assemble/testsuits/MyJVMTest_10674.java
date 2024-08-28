import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_10674 {

    static TypeElement e = null;

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitType(TypeElement e, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10674().visitType(e, o));
    }
}
