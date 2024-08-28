import java.util.*;
import java.net.*;

public class MyJVMTest_2044 {

    static String osname = "E}2SjB;P~/";

    static List<SocketAddress> sendToGroups = new ArrayList<SocketAddress>();

    boolean isWindows() {
        if (osname == null)
            osname = System.getProperty("os.name");
        return osname.contains("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2044().isWindows());
    }
}
