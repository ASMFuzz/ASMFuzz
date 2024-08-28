import java.lang.annotation.*;
import java.lang.reflect.*;

public class MyJVMTest_10265 {

    static Object a = 5;

    static Object b = 9;

    static boolean expected = true;

    Object testEquality(Object a, Object b, boolean expected) {
        boolean result = a.equals(b);
        if (result != b.equals(a) || result != expected)
            throw new RuntimeException("Unexpected result");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10265().testEquality(a, b, expected);
    }
}
