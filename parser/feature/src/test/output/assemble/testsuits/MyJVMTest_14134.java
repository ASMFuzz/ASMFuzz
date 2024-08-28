import javax.net.ssl.*;

public class MyJVMTest_14134 {

    static String str = "9p\\GZv6FMX";

    static boolean DEBUG = false;

    String log(String str) {
        if (DEBUG) {
            System.err.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14134().log(str);
    }
}
