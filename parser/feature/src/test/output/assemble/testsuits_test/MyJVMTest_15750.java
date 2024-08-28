import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15750 {

    static byte[] data = {55,79,95,44,-109,-80,104,32,-7,59};

    static boolean debug = false;

    static int deflatedLength = 6;

    int getDeflatedLength() throws Throwable {
        int rc = 0;
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        byte[] out = new byte[data.length];
        rc = deflater.deflate(out);
        deflater.end();
        if (debug)
            System.out.println("deflatedLength is " + rc);
        return rc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15750().getDeflatedLength());
    }
}
