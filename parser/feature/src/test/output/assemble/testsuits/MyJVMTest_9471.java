import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_9471 {

    static int DATA_LEN = 1024 * 128;

    static byte[] data = {-45,-12,120,28,-20,48,36,-125,30,103};

    static boolean debug = false;

    static int deflatedLength = 6;

    void createData() {
        ByteBuffer bb = ByteBuffer.allocate(8);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < DATA_LEN; i++) {
            bb.putDouble(0, Math.random());
            baos.write(bb.array(), 0, 8);
        }
        data = baos.toByteArray();
        if (debug)
            System.out.println("data length is " + data.length);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9471().createData();
    }
}
