import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_317 {

    static int DATA_LEN = 1024 * 128;

    static byte[] data = {-21,38,75,45,119,26,53,18,71,105};

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
        new MyJVMTest_317().createData();
    }
}
