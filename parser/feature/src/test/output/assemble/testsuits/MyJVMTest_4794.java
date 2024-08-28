import java.lang.management.*;
import java.lang.reflect.*;
import java.util.*;
import javax.management.*;

public class MyJVMTest_4794 {

    static Object x = 0;

    static Object y = 6;

    static String what = "8R^dEbEqzi";

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
        new MyJVMTest_4794().checkEqual(x, y, what);
    }
}
