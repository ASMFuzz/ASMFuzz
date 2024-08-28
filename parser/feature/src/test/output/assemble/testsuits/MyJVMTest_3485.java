import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_3485 {

    static Object bsmInfo = 0;

    static Object args = 5;

    static boolean doPrint = true;

    static Lookup caller = null;

    static String name = "{qo+\\S1v^B";

    static Object[] staticArgs = {5,0,4,0,3,0,-357275881,0,0,929382448};

    static PermissionCollection permissions = new Permissions();

    String printArgs(Object bsmInfo, Object... args) {
        String message = bsmInfo + Arrays.deepToString(args);
        if (doPrint)
            System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3485().printArgs(bsmInfo, args);
    }
}
