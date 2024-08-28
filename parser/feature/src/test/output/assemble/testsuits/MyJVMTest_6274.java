import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6274 {

    static byte[] data = {30,106,73,67,-95,62,-5,-45,127,-100};

    static boolean debug = false;

    static int deflatedLength = 1;

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
        System.out.println(new MyJVMTest_6274().getDeflatedLength());
    }
}
