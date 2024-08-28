import java.net.*;
import java.nio.channels.*;
import static java.nio.channels.SelectionKey.*;

public class MyJVMTest_8739 {

    static boolean v = true;

    static String msg = "OzL8doj-Z\"";

    boolean assertTrue(boolean v, String msg) {
        if (!v)
            throw new RuntimeException(msg);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8739().assertTrue(v, msg);
    }
}
