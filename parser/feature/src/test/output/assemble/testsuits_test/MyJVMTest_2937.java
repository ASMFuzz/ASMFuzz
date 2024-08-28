import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_2937 {

    static byte[] data = { 100, -37, -48, -21, 26, -7, -16, -47, -44, -72 };

    static int ignored = -1342683899;

    byte[] deflate(byte[] data, int ignored) throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream gzos = new GZIPOutputStream(baos);
        gzos.write(data, 0, data.length);
        gzos.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2937().deflate(data, ignored)));
    }
}
