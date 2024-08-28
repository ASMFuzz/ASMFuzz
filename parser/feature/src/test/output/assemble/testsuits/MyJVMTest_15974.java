import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15974 {

    static byte[] dict = { 36, 89, 103, 105, 44, 95, 101, 53, 15, -39 };

    static byte[] data = new byte[1024 * 1024];

    static ByteArrayInputStream bais = null;

    static DeflaterInputStream dis = null;

    static ByteArrayOutputStream baos = null;

    static InflaterOutputStream ios = null;

    Inflater reset(byte[] dict) {
        bais = new ByteArrayInputStream(data);
        if (dict == null) {
            dis = new DeflaterInputStream(bais);
        } else {
            Deflater def = new Deflater();
            def.setDictionary(dict);
            dis = new DeflaterInputStream(bais, def);
        }
        baos = new ByteArrayOutputStream();
        if (dict == null) {
            ios = new InflaterOutputStream(baos);
            return null;
        } else {
            Inflater inf = new Inflater();
            ios = new InflaterOutputStream(baos, inf);
            return inf;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15974().reset(dict));
    }
}
