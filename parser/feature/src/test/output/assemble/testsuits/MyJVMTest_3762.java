import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_3762 {

    static WildcardType t = null;

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitWildcard(WildcardType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3762().visitWildcard(t, o));
    }
}
