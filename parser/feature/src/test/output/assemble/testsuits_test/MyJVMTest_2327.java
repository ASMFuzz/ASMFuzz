import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_2327 {

    static int outParam1Param1 = 430;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ZipOutputStream out = new ZipOutputStream(outParam1);

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
        new MyJVMTest_2327().testWrite(out);
    }
}
