import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_5183 {

    static PackageElement e = null;

    static Object o = 1;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitPackage(PackageElement e, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5183().visitPackage(e, o));
    }
}
