import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_1699 {

    static ExecutableType t = null;

    static Object o = 6;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitExecutable(ExecutableType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1699().visitExecutable(t, o));
    }
}
