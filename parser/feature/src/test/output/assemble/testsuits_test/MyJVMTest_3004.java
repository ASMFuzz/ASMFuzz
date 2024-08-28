import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_3004 {

    static int count = 1;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipEntry getEntry() {
        return new ZipEntry("jar" + count++ + ".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3004().getEntry());
    }
}
