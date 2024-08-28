import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_14375 {

    static int i = 7;

    static Object o = 9;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitInt(int i, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14375().visitInt(i, o));
    }
}
