import java.util.*;
import java.net.*;

public class MyJVMTest_11290 {

    static String osname = "|=(:K2),{ ";

    static List<SocketAddress> sendToGroups = new ArrayList<SocketAddress>();

    boolean isWindows() {
        if (osname == null)
            osname = System.getProperty("os.name");
        return osname.contains("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11290().isWindows());
    }
}
