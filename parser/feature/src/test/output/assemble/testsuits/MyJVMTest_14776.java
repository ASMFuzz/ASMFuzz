import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_14776 {

    static IntersectionType t = null;

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitIntersection(IntersectionType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14776().visitIntersection(t, o));
    }
}
