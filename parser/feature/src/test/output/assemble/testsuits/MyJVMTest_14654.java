import javax.security.auth.x500.X500Principal;

public class MyJVMTest_14654 {

    static String in = "@dRF!Bn2-0";

    static String outFormat = "4F h'M:_Z ";

    static String expect = "7Ud)+k-[k*";

    static int n = 623445697;

    int testName(String in, String outFormat, String expect, int n) throws Exception {
        X500Principal p = new X500Principal(in);
        if (outFormat.equalsIgnoreCase("toString")) {
            if (p.toString().equals(expect)) {
                System.out.println("test " + n + " succeeded");
            } else {
                throw new SecurityException("test " + n + " failed:\n" + "expected '" + expect + "'\n" + "got '" + p.toString() + "'");
            }
        } else {
            if (p.getName(outFormat).equals(expect)) {
                System.out.println("test " + n + " succeeded");
            } else {
                throw new SecurityException("test " + n + " failed:\n" + "expected '" + expect + "'\n" + "got '" + p.getName(outFormat) + "'");
            }
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14654().testName(in, outFormat, expect, n);
    }
}
