import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_10921 {

    static ExecutableType t = null;

    static Object o = 8;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitExecutable(ExecutableType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10921().visitExecutable(t, o));
    }
}
