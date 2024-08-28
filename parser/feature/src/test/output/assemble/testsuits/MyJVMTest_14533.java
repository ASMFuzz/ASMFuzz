import java.net.*;
import java.nio.channels.*;
import static java.nio.channels.SelectionKey.*;

public class MyJVMTest_14533 {

    static boolean v = false;

    static String msg = "]X0E>K2(#q";

    boolean assertTrue(boolean v, String msg) {
        if (!v)
            throw new RuntimeException(msg);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14533().assertTrue(v, msg);
    }
}
