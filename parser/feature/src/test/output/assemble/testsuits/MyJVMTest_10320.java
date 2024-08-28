import java.io.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_10320 {

    static Selector sel = null;

    SelectionKey reg(Selector sel) throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        return dc.register(sel, SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10320().reg(sel));
    }
}
