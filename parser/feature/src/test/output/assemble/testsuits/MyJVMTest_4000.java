import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4000 {

    static int ignored = 0;

    static String name = "z.6ZR\\o($2";

    static byte[] data = {119,-84,-20,-111,114,-74,24,46,52,10};

    static int level = 4;

    static int STRIDE = 1024;

    byte[] deflate(byte[] data, int ignored) throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream gzos = new GZIPOutputStream(baos);
        gzos.write(data, 0, data.length);
        gzos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4000().deflate(data, ignored)));
    }
}
