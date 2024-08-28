import java.lang.management.*;
import java.lang.reflect.*;
import java.util.*;
import javax.management.*;

public class MyJVMTest_14193 {

    static Object x = 2;

    static Object y = 0;

    static String what = "{w2&`mwCjg";

    boolean checkEqual(Object x, Object y, String what) {
        final boolean eq;
        if (x == y)
            eq = true;
        else if (x == null)
            eq = false;
        else
            eq = x.equals(y);
        if (!eq)
            throw new RuntimeException(what + " should be " + y + ", is " + x);
        return eq;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14193().checkEqual(x, y, what);
    }
}
