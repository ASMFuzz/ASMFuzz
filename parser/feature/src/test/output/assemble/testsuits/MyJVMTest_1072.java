import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_1072 {

    static Object a = 6;

    static Object b = -1994410494;

    static boolean expected = false;

    Object testEquality(Object a, Object b, boolean expected) {
        boolean result = a.equals(b);
        if (result != b.equals(a) || result != expected)
            throw new RuntimeException("Unexpected result");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1072().testEquality(a, b, expected);
    }
}
