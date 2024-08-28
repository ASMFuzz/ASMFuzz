import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_13352 {

    static int ignored = -474127480;

    static String name = "`p:2ykrF$)";

    static byte[] data = {-4,14,-95,74,98,-85,77,-127,108,-109};

    static int level = -737959048;

    static int STRIDE = 1024;

    byte[] deflate(byte[] data, int ignored) throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream gzos = new GZIPOutputStream(baos);
        gzos.write(data, 0, data.length);
        gzos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13352().deflate(data, ignored)));
    }
}
