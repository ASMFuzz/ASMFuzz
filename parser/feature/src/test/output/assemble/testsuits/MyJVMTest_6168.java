import java.io.*;
import java.net.*;

public class MyJVMTest_6168 {

    static String msg = ":]9UsgEv1>";

    static Object args = 1;

    static int thread_id = 5;

    String log(String msg, Object... args) {
        String msg0 = "ParallelLoadThread: " + String.format(msg, args);
        System.out.println(msg0);
        return msg0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6168().log(msg, args);
    }
}
