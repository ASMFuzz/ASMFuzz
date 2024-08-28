import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15803 {

    static int DATA_LEN = 1024 * 64;

    static byte[] data = {-10,-1,-16,-8,103,52,71,-45,-20,-81};

    void createData() {
        ByteBuffer bb = ByteBuffer.allocate(8);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < DATA_LEN; i++) {
            bb.putDouble(0, Math.random());
            baos.write(bb.array(), 0, 8);
        }
        data = baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15803().createData();
    }
}
