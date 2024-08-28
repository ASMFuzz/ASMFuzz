import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_16729 {

    static PrintStream oldOut = null;

    static ByteArrayOutputStream buf = null;

    static String[] EXPECT_OUTPUT = { "Obtaining method handle constants:", "MethodHandle(String,char,char)String", "MethodHandle(MethodHandle,String,char,char)String", "MethodHandle(MethodHandle,String,char,char)String", "MethodHandle(String)Class", "MethodHandle(String,boolean,ClassLoader)Class", "Done." };

    static PermissionCollection permissions = new Permissions();

    void closeBuf() {
        if (buf == null)
            return;
        System.out.flush();
        System.setOut(oldOut);
        String[] haveLines = new String(buf.toByteArray()).split("[\n\r]+");
        for (String line : haveLines) System.out.println(line);
        Iterator<String> iter = Arrays.asList(haveLines).iterator();
        for (String want : EXPECT_OUTPUT) {
            String have = iter.hasNext() ? iter.next() : "[EOF]";
            if (want.equals(have))
                continue;
            System.err.println("want line: " + want);
            System.err.println("have line: " + have);
            throw new AssertionError("unexpected output: " + have);
        }
        if (iter.hasNext())
            throw new AssertionError("unexpected output: " + iter.next());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16729().closeBuf();
    }
}
