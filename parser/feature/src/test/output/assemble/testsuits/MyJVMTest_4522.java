import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_4522 {

    static boolean b = true;

    static Object o = 1454456203;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitBoolean(boolean b, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4522().visitBoolean(b, o));
    }
}
