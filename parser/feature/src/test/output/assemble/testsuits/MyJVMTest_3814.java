import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import javax.management.openmbean.ArrayType;

public class MyJVMTest_3814 {

    static int tParam1 = 980;

    static OpenType<?> tParam2 = null;

    static ArrayType t = new ArrayType(tParam1, tParam2);

    static Object o = 0;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitArray(ArrayType t, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3814().visitArray(t, o));
    }
}
