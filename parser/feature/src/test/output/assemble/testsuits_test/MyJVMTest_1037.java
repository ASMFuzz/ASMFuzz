import java.net.*;
import java.util.*;

public class MyJVMTest_1037 {

    static boolean ipv6Address = true;

    static NetworkInterface nic = null;

    boolean ipv6Address(boolean ipv6Address) {
        this.ipv6Address = ipv6Address;
        return ipv6Address;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1037().ipv6Address(ipv6Address);
    }
}
