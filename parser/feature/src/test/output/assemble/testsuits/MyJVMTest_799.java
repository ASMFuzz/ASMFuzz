import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class MyJVMTest_799 {

    static ByteArrayOutputStream baos = new ByteArrayOutputStream();

    ZipOutputStream getOutputStream(ByteArrayOutputStream baos) throws IOException {
        return new JarOutputStream(baos);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_799().getOutputStream(baos));
    }
}
