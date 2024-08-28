import java.util.*;

public class MyJVMTest_2278 {

    static String message = "#\\%>c%Em8O";

    static boolean DEBUG = true;

    String debuglog(String message) {
        if (DEBUG) {
            System.out.println(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2278().debuglog(message);
    }
}
