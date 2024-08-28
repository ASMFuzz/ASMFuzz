import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9738 {

    static PrintStream oldOut = null;

    static ByteArrayOutputStream buf = null;

    static String[] EXPECT_OUTPUT = { "Printing some argument lists, starting with a empty one:", "[test.java.lang.invoke.InvokeDynamicPrintArgs, nothing, ()void][]", "[test.java.lang.invoke.InvokeDynamicPrintArgs, bar, (String,int)void, class java.lang.Void, void type!, 1, 234.5, 67.5, 89][bar arg, 1]", "[test.java.lang.invoke.InvokeDynamicPrintArgs, bar2, (String,int)void, class java.lang.Void, void type!, 1, 234.5, 67.5, 89][bar2 arg, 222]", "[test.java.lang.invoke.InvokeDynamicPrintArgs, baz, (String,int,double)void, 1234.5][baz arg, 2, 3.14]", "[test.java.lang.invoke.InvokeDynamicPrintArgs, foo, (String)void][foo arg]", "Done printing argument lists." };

    static Lookup caller = null;

    static String name = "Mv^93r$e@v";

    static Object[] staticArgs = {1,5,2,9,8,9,4,-234296165,-192658678,1};

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
        new MyJVMTest_9738().closeBuf();
    }
}
