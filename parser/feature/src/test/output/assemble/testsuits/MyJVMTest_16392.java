import java.io.File;

public class MyJVMTest_16392 {

    static String fn1 = "FbMqv#F<*|";

    static String fn2 = "S<=ey%$V*~";

    File test(String fn1, String fn2) throws Exception {
        File f1 = new File(fn1);
        File f2 = new File(fn2);
        if (!f1.equals(f2))
            throw new Exception("Instances with equal paths are not equal");
        int h1 = f1.hashCode();
        int h2 = f2.hashCode();
        if (h1 != h2)
            throw new Exception("Hashcodes of equal instances are not equal");
        return f2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16392().test(fn1, fn2);
    }
}
