import java.io.*;
import java.util.*;

public class MyJVMTest_15829 {

    static String message = "Bad suppressed exception information";

    void initCausePlumbing() {
        Throwable t1 = new Throwable();
        Throwable t2 = new Throwable("message", t1);
        Throwable t3 = new Throwable();
        try {
            t2.initCause(t3);
            throw new RuntimeException("Shouldn't reach.");
        } catch (IllegalStateException ise) {
            if (ise.getCause() != t2)
                throw new RuntimeException("Unexpected cause in ISE", ise);
            Throwable[] suppressed = ise.getSuppressed();
            if (suppressed.length != 0)
                throw new RuntimeException("Bad suppression in ISE", ise);
        }
        try {
            t2.initCause(null);
            throw new RuntimeException("Shouldn't reach.");
        } catch (IllegalStateException ise) {
            ;
        }
        try {
            t3.initCause(t3);
            throw new RuntimeException("Shouldn't reach.");
        } catch (IllegalArgumentException iae) {
            if (iae.getCause() != t3)
                throw new RuntimeException("Unexpected cause in ISE", iae);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15829().initCausePlumbing();
    }
}
