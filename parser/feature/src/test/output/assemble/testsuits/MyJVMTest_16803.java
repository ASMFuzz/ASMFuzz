import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_16803 {

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16803().pass();
    }
}
