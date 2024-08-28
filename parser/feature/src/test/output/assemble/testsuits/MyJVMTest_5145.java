import java.io.PrintStream;

public class MyJVMTest_5145 {

    static int i = 0;

    static String desc = "$vcsWt8Tx0";

    static float r = Float.NaN;

    static PrintStream out = null;

    static float halfUlp = 0f;

    float pr(int i, String desc, float r) {
        out.print(" i=(" + i + ") " + desc + " ; == " + r);
        out.println(" , 0x" + Integer.toHexString(Float.floatToIntBits(r)));
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5145().pr(i, desc, r);
    }
}
