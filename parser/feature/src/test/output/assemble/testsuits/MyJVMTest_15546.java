import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_15546 {

    static Method m = null;

    static int index = 1719487226;

    static boolean z = true;

    static int[] array = new int[10];

    Method invokeTest(Method m, int[] array, int index, boolean z) {
        try {
            m.invoke(null, array, index, z);
        } catch (ReflectiveOperationException roe) {
            Throwable ex = roe.getCause();
            if (ex instanceof ArrayIndexOutOfBoundsException)
                throw (ArrayIndexOutOfBoundsException) ex;
            throw new AssertionError(roe);
        }
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15546().invokeTest(m, array, index, z);
    }
}
