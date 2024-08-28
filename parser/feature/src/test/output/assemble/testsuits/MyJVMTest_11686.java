import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11686 {

    static PrintStream oldOut = null;

    static ByteArrayOutputStream buf = null;

    static Lookup caller = null;

    static String name = "3#}M<sTWmi";

    static Object[] staticArgs = {9,0,4,0,4,0,8,2,8,0};

    static PermissionCollection permissions = new Permissions();

    void openBuf() {
        oldOut = System.out;
        buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11686().openBuf();
    }
}
