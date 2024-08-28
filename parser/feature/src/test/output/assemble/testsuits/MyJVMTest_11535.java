import java.util.*;

public class MyJVMTest_11535 {

    static String message = "3:&_~_~#vp";

    static boolean DEBUG = true;

    String debuglog(String message) {
        if (DEBUG) {
            System.out.println(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11535().debuglog(message);
    }
}
