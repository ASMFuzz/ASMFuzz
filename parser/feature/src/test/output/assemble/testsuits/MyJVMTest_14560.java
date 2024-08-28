import java.io.PrintStream;

public class MyJVMTest_14560 {

    static int i = 0;

    static String desc = "AP{jQT,%m=";

    static float r = Float.MAX_VALUE;

    static PrintStream out = null;

    static float halfUlp = Float.MIN_VALUE;

    float pr(int i, String desc, float r) {
        out.print(" i=(" + i + ") " + desc + " ; == " + r);
        out.println(" , 0x" + Integer.toHexString(Float.floatToIntBits(r)));
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14560().pr(i, desc, r);
    }
}
