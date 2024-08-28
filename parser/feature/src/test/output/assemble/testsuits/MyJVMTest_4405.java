import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4405 {

    static int DATA_LEN = 1024 * 128;

    static ByteBuffer dataDirect = null;

    static ByteBuffer dataHeap = null;

    static boolean debug = false;

    static int deflatedLength = 0;

    static int srcMode = 7, dstMode = -1005734137;

    void createData() {
        ByteBuffer bb = ByteBuffer.allocateDirect(DATA_LEN * 8);
        for (int i = 0; i < DATA_LEN * 8; i += 8) {
            bb.putDouble(i, Math.random());
        }
        dataDirect = bb;
        final ByteBuffer hb = ByteBuffer.allocate(bb.capacity());
        hb.duplicate().put(bb.duplicate());
        dataHeap = hb;
        if (debug)
            System.out.println("data length is " + bb.capacity());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4405().createData();
    }
}
