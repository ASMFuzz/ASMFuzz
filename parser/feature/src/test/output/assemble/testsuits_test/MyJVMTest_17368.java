import java.io.*;
import java.util.logging.*;
import java.util.zip.*;

public class MyJVMTest_17368 {

    static String name = "-1yl{E|~^[";

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
        System.out.println(new MyJVMTest_17368().createTextFile(name));
    }
}
