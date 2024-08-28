import java.net.*;
import java.nio.channels.*;
import static java.nio.channels.SelectionKey.*;

public class MyJVMTest_1014 {

    static int ops = 1;

    String toOpsString(int ops) {
        String s = "";
        if ((ops & OP_READ) > 0)
            s += "POLLIN";
        if ((ops & OP_WRITE) > 0) {
            if (s.length() > 0)
                s += "|";
            s += "POLLOUT";
        }
        if (s.length() == 0)
            s = "0";
        return "(" + s + ")";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1014().toOpsString(ops));
    }
}
