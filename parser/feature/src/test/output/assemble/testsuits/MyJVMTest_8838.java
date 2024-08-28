import java.util.*;

public class MyJVMTest_8838 {

    static String message = "y%&GYY~\\q#";

    static boolean DEBUG = true;

    String debuglog(String message) {
        if (DEBUG) {
            System.out.println(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8838().debuglog(message);
    }
}
