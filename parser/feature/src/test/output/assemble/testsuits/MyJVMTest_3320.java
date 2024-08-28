import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3320 {

    static VariableElement e = null;

    static Object o = 6;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitVariable(VariableElement e, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3320().visitVariable(e, o));
    }
}
