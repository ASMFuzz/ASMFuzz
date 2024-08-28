import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_14022 {

    static int defParam1 = 788;

    static Deflater def = new Deflater(defParam1);

    static int level = -2052076846;

    static int strategy = -1117125942;

    Deflater resetDeflater(Deflater def, int level, int strategy) {
        def.setLevel(level);
        def.setStrategy(strategy);
        def.reset();
        return def;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14022().resetDeflater(def, level, strategy));
    }
}
