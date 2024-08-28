import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3032 {

    static double d = Double.MAX_VALUE;

    static Object o = 874463779;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitDouble(double d, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3032().visitDouble(d, o));
    }
}
