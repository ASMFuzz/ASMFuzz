import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_790 {

    static long i = -9223372036854775808L;

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitLong(long i, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_790().visitLong(i, o));
    }
}
