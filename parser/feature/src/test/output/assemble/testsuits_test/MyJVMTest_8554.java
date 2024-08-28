import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_8554 {

    static int count = 1;

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipEntry getEntry() {
        return new ZipEntry("zip" + count++ + ".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8554().getEntry());
    }
}
