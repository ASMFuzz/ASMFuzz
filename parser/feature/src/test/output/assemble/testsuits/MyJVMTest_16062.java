import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_16062 {

    static String s = "$<M/Sy3w_7";

    static Object o = 8;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitString(String s, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16062().visitString(s, o));
    }
}
