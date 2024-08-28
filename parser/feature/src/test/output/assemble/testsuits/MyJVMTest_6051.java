import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6051 {

    static int length = 0;

    static byte[] data = {-107,-115,94,-73,40,-123,54,-79,43,16};

    static int deflatedLength = -274389160;

    byte[] DeflateData(int length) throws Throwable {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        byte[] out = new byte[length];
        deflater.deflate(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6051().DeflateData(length)));
    }
}
