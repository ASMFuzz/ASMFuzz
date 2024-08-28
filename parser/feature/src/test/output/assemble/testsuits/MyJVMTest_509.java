import java.io.*;
import java.util.*;

public class MyJVMTest_509 {

    static Throwable t = new Throwable();

    Throwable assertEmptyStackTrace(Throwable t) {
        if (t.getStackTrace().length != 0)
            throw new AssertionError("Nonempty stacktrace.");
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_509().assertEmptyStackTrace(t);
    }
}
