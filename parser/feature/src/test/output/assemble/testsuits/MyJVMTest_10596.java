import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_10596 {

    static float f = Float.NaN;

    static Object o = 7;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitFloat(float f, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10596().visitFloat(f, o));
    }
}
