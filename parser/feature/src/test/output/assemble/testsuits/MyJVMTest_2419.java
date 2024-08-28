import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2419 {

    static PrintStream oldOut = null;

    static ByteArrayOutputStream buf = null;

    static Lookup caller = null;

    static String name = "dzzSUMN0DP";

    static Object[] staticArgs = {4,5,1,8,0,7,0,0,3,331710115};

    static PermissionCollection permissions = new Permissions();

    void openBuf() {
        oldOut = System.out;
        buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2419().openBuf();
    }
}
