import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_16642 {

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipOutputStream getOutputStream(ByteArrayOutputStream baos) throws IOException {
        return new JarOutputStream(baos);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16642().getOutputStream(baos));
    }
}
