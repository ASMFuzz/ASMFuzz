import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_14064 {

    static short s = 32767;

    static Object o = 7;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitShort(short s, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14064().visitShort(s, o));
    }
}
