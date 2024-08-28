import java.lang.management.*;
import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_11538 {

    static String title = "+j;>29rUs&";

    static StackTraceElement[] stack = { null, null, null, null, null, null, null, null, null, null };

    StackTraceElement[] showStackTrace(String title, StackTraceElement[] stack) {
        System.out.println("---" + title + "---");
        if (stack == null)
            System.out.println("<no stack trace???>");
        else {
            for (StackTraceElement elmt : stack) System.out.println("    " + elmt);
        }
        System.out.println();
        return stack;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11538().showStackTrace(title, stack);
    }
}
