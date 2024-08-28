import java.io.*;
import java.util.*;

public class MyJVMTest_17441 {

    static String message = "Bad suppressed exception information";

    void basicSupressionTest() {
        Throwable throwable = new Throwable();
        RuntimeException suppressed = new RuntimeException("A suppressed exception.");
        AssertionError repressed = new AssertionError("A repressed error.");
        Throwable[] t0 = throwable.getSuppressed();
        if (t0.length != 0) {
            throw new RuntimeException(message);
        }
        throwable.printStackTrace();
        throwable.addSuppressed(suppressed);
        Throwable[] t1 = throwable.getSuppressed();
        if (t1.length != 1 || t1[0] != suppressed) {
            throw new RuntimeException(message);
        }
        throwable.printStackTrace();
        throwable.addSuppressed(repressed);
        Throwable[] t2 = throwable.getSuppressed();
        if (t2.length != 2 || t2[0] != suppressed || t2[1] != repressed) {
            throw new RuntimeException(message);
        }
        throwable.printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17441().basicSupressionTest();
    }
}
