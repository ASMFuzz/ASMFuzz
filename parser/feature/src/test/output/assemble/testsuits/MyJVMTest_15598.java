import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_15598 {

    static ExecutableElement e = null;

    static Object o = 7;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitExecutable(ExecutableElement e, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15598().visitExecutable(e, o));
    }
}
