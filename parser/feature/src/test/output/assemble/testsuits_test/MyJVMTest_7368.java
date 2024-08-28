import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_7368 {

    static int level = 708351166;

    static int strategy = 2;

    static boolean dowrap = true;

    static byte[] tmp = { 60, 96, 3, 43, -30, 113, 105, -108, 87, 124 };

    Deflater newDeflater(int level, int strategy, boolean dowrap, byte[] tmp) {
        Deflater def = new Deflater(level, dowrap);
        if (strategy != Deflater.DEFAULT_STRATEGY) {
            def.setStrategy(strategy);
            def.deflate(tmp);
        }
        return def;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7368().newDeflater(level, strategy, dowrap, tmp));
    }
}
