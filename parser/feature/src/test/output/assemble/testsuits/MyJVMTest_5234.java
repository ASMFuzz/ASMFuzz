import javax.security.auth.x500.X500Principal;

public class MyJVMTest_5234 {

    static String in = "ic,R\\%{)2p";

    static String outFormat = "gQsB]/l?,6";

    static String expect = "cQf}~uSgW ";

    static int n = 0;

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
        new MyJVMTest_5234().testName(in, outFormat, expect, n);
    }
}
