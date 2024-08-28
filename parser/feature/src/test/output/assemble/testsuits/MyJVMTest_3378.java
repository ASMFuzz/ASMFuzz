import java.io.*;
import java.util.*;

public class MyJVMTest_3378 {

    static String eParam1 = "fceve5_8\"B";

    static String eParam2 = "Tl8u+'@r$y";

    static String eParam3 = " I!]F'~Y/n";

    static int eParam4 = 748;

    static StackTraceElement e = new StackTraceElement(eParam1, eParam2, eParam3, eParam4);

    static String methodName = "2Tr|iy'^Zb";

    static int n = 2;

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
        new MyJVMTest_3378().check(e, methodName, n);
    }
}
