import com.sun.net.httpserver.*;
import java.net.*;

public class MyJVMTest_8230 {

    static boolean val = false;

    boolean checkValue(boolean val) {
        if (val)
            throw new RuntimeException("Return value is not false!");
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8230().checkValue(val);
    }
}
