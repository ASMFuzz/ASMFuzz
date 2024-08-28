import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3643 {

    static UnionType t = null;

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitUnion(UnionType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3643().visitUnion(t, o));
    }
}
