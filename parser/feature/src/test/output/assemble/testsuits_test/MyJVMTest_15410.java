import java.lang.invoke.*;

public class MyJVMTest_15410 {

    static String x = "<v'{fd+`(3";

    static String e = "5FVp6 Ptrp";

    static String a = "'ekxFVTXI ";

    static boolean DEBUG = System.getProperty("DEBUG", "false").equals("true");

    String p(String x, String e, String a) {
        if (DEBUG)
            System.out.println(x + ": expected: " + e + ", actual: " + a);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15410().p(x, e, a);
    }
}
