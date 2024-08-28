import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_11704 {

    static byte[] data = new byte[1024 * 1024];

    static ByteArrayInputStream bais = null;

    static DeflaterInputStream dis = null;

    static ByteArrayOutputStream baos = null;

    static InflaterOutputStream ios = null;

    void reset() {
        new Random(new Date().getTime()).nextBytes(data);
        bais = new ByteArrayInputStream(data);
        dis = new DeflaterInputStream(bais);
        baos = new ByteArrayOutputStream();
        ios = new InflaterOutputStream(baos);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11704().reset();
    }
}
