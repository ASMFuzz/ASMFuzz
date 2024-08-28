import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4632 {

    static Deflater def = new Deflater();

    static int level = 679605884;

    static int strategy = 0;

    Deflater resetDeflater(Deflater def, int level, int strategy) {
        def.setLevel(level);
        def.setStrategy(strategy);
        def.reset();
        return def;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4632().resetDeflater(def, level, strategy));
    }
}
