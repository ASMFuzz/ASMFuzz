import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_8182 {

    static byte b = 127;

    static Object o = -574348826;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitByte(byte b, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8182().visitByte(b, o));
    }
}
