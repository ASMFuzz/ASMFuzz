import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_2111 {

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    ZipOutputStream getOutputStream(ByteArrayOutputStream baos) throws IOException {
        return new ZipOutputStream(baos);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2111().getOutputStream(baos));
    }
}
