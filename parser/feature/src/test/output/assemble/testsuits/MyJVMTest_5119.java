import java.net.*;
import java.nio.channels.*;
import static java.nio.channels.SelectionKey.*;

public class MyJVMTest_5119 {

    static boolean v = true;

    static String msg = "l1RHqo>lrG";

    boolean assertTrue(boolean v, String msg) {
        if (!v)
            throw new RuntimeException(msg);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5119().assertTrue(v, msg);
    }
}
