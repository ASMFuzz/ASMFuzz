import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_4969 {

    static int i = 0;

    static Object o = 1102277643;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitInt(int i, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4969().visitInt(i, o));
    }
}
