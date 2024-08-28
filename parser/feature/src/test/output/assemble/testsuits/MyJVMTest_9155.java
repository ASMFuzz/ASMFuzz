import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9155 {

    static PrintStream oldOut = null;

    static ByteArrayOutputStream buf = null;

    static PermissionCollection permissions = new Permissions();

    void openBuf() {
        oldOut = System.out;
        buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9155().openBuf();
    }
}
