import java.lang.invoke.*;

public class MyJVMTest_5957 {

    static String x = "O~#>'~LnN]";

    static String e = ";:G;}?]'5L";

    static String a = "oW%@m9qD0?";

    static boolean DEBUG = System.getProperty("DEBUG", "false").equals("true");

    String p(String x, String e, String a) {
        if (DEBUG)
            System.out.println(x + ": expected: " + e + ", actual: " + a);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5957().p(x, e, a);
    }
}
