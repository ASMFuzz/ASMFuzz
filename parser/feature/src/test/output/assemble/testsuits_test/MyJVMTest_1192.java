import java.net.*;
import java.util.*;

public class MyJVMTest_1192 {

    static String message = ";K4eDviTL4";

    static boolean debug = true;

    String debug(String message) {
        if (debug)
            System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1192().debug(message);
    }
}
