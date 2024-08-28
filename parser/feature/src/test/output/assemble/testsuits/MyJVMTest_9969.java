import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_9969 {

    static long i = 9223372036854775807L;

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitLong(long i, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9969().visitLong(i, o));
    }
}
