import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import javax.management.openmbean.ArrayType;

public class MyJVMTest_13155 {

    static SimpleType<?> tParam1 = null;

    static boolean tParam2 = true;

    static ArrayType t = new ArrayType(tParam1, tParam2);

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitArray(ArrayType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13155().visitArray(t, o));
    }
}
