import java.net.*;
import java.util.*;

public class MyJVMTest_10391 {

    static String message = "]F] aI{J[~";

    static boolean debug = true;

    String debug(String message) {
        if (debug)
            System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10391().debug(message);
    }
}
