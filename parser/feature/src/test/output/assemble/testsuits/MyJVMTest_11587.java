import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_11587 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static Charset outParam2 = null;

    static ZipOutputStream out = new ZipOutputStream(outParam1, outParam2);

    ZipOutputStream testWrite(ZipOutputStream out) throws Exception {
        out.close();
        try {
            out.putNextEntry(new ZipEntry(""));
            throw new Exception("write allowed after stream is closed");
        } catch (IOException e) {
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11587().testWrite(out);
    }
}
