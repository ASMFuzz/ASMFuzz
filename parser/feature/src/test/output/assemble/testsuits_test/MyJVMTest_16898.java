import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_16898 {

    static int level = -1686837893;

    static int strategy = 0;

    static boolean dowrap = true;

    static byte[] tmp = { 90, 113, 45, -31, -104, 19, 14, 27, -5, -98 };

    Deflater newDeflater(int level, int strategy, boolean dowrap, byte[] tmp) {
        Deflater def = new Deflater(level, dowrap);
        if (strategy != Deflater.DEFAULT_STRATEGY) {
            def.setStrategy(strategy);
            def.deflate(tmp);
        }
        return def;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16898().newDeflater(level, strategy, dowrap, tmp));
    }
}
