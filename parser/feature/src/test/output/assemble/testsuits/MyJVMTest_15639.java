import java.io.*;
import java.net.*;

public class MyJVMTest_15639 {

    static String msg = "%+H.DDyrYo";

    static Object args = -112445602;

    static int thread_id = 0;

    String log(String msg, Object... args) {
        String msg0 = "ParallelLoadThread: " + String.format(msg, args);
        System.out.println(msg0);
        return msg0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15639().log(msg, args);
    }
}
