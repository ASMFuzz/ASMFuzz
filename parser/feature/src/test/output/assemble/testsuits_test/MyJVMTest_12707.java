import java.io.*;
import java.util.*;

public class MyJVMTest_12707 {

    static String eParam1 = "X.qn6|De/X";

    static String eParam2 = "d1g:(iSaP ";

    static String eParam3 = "+;fE|>kw6G";

    static int eParam4 = 486;

    static StackTraceElement e = new StackTraceElement(eParam1, eParam2, eParam3, eParam4);

    static String methodName = "Fqa;Yk[=\\6";

    static int n = -397888829;

    static String OUR_CLASS = StackTraceSerialization.class.getName();

    static String OUR_FILE_NAME = "StackTraceSerialization.java";

    StackTraceElement check(StackTraceElement e, String methodName, int n) {
        if (!e.getClassName().equals(OUR_CLASS))
            throw new RuntimeException("Class: " + e);
        if (!e.getMethodName().equals(methodName))
            throw new RuntimeException("Method name: " + e);
        if (!e.getFileName().equals(OUR_FILE_NAME))
            throw new RuntimeException("File name: " + e);
        if (e.getLineNumber() != n)
            throw new RuntimeException("Line number: " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12707().check(e, methodName, n);
    }
}
