import java.io.*;
import java.util.*;

public class MyJVMTest_9671 {

    static String tParam1Param1 = "1}JPD:sN+D";

    static String tParam1Param2Param1 = "s`d;X6GM^%";

    static Throwable tParam1Param2 = new Throwable(tParam1Param2Param1);

    static Throwable tParam1 = new Throwable(tParam1Param1, tParam1Param2);

    static Throwable t = new Throwable(tParam1);

    Throwable assertEmptyStackTrace(Throwable t) {
        if (t.getStackTrace().length != 0)
            throw new AssertionError("Nonempty stacktrace.");
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9671().assertEmptyStackTrace(t);
    }
}
