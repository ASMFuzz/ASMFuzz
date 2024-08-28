import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_12338 {

    static double d = Double.NaN;

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitDouble(double d, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12338().visitDouble(d, o));
    }
}
