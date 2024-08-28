import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_4859 {

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipInputStream getInputStream() {
        return new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4859().getInputStream());
    }
}
