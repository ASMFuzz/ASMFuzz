import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_13910 {

    static boolean b = false;

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitBoolean(boolean b, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13910().visitBoolean(b, o));
    }
}
