import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_18084 {

    static VariableElement c = null;

    static Object o = -638052562;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitEnumConstant(VariableElement c, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18084().visitEnumConstant(c, o));
    }
}
