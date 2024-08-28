import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;

public class MyJVMTest_17755 {

    static byte b = 127;

    static Object o = 4;

    String throwUOE() {
        throw new UnsupportedOperationException();
    }

    String visitByte(byte b, Object o) {
        return throwUOE();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17755().visitByte(b, o));
    }
}
