import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12816 {

    static Object bsmInfo = 0;

    static Object args = 0;

    static boolean doPrint = true;

    static Lookup caller = null;

    static String name = "y!>=f_BAok";

    static Object[] staticArgs = {-648691467,35508434,0,6,0,-393409403,9,0,2,3};

    static PermissionCollection permissions = new Permissions();

    String printArgs(Object bsmInfo, Object... args) {
        String message = bsmInfo + Arrays.deepToString(args);
        if (doPrint)
            System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12816().printArgs(bsmInfo, args);
    }
}
