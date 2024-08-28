import java.io.*;
import java.util.logging.*;
import java.util.zip.*;

public class MyJVMTest_7809 {

    static String name = "R:A5}ppOm!";

    static boolean debug = true;

    File createTextFile(String name) throws Throwable {
        File rc = File.createTempFile(name, ".txt");
        if (!debug)
            rc.deleteOnExit();
        PrintWriter pw = new PrintWriter(rc);
        pw.println("hello, world");
        pw.close();
        return rc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7809().createTextFile(name));
    }
}
