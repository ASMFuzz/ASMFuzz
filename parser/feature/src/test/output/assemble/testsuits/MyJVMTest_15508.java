import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15508 {

    static int length = 0;

    static byte[] data = {-92,25,127,-122,-54,97,89,23,-60,-9};

    static int deflatedLength = 7;

    byte[] DeflateData(int length) throws Throwable {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        byte[] out = new byte[length];
        deflater.deflate(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15508().DeflateData(length)));
    }
}
