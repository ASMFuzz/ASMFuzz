import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_1385 {

    static float f = Float.NEGATIVE_INFINITY;

    static Object o = 6;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitFloat(float f, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1385().visitFloat(f, o));
    }
}
