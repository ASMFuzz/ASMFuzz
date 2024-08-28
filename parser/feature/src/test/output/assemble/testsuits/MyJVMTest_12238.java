import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_12238 {

    static byte[] data = { 47, -107, -67, -82, -45, 73, -27, 89, 77, 46 };

    static int ignored = 0;

    byte[] deflate(byte[] data, int ignored) throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream gzos = new GZIPOutputStream(baos);
        gzos.write(data, 0, data.length);
        gzos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12238().deflate(data, ignored)));
    }
}
