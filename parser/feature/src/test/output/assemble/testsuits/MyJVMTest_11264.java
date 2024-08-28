import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_11264 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11264().check(cond);
    }
}
