import java.net.*;
import java.util.*;

public class MyJVMTest_10228 {

    static boolean ipv6Address = false;

    static NetworkInterface nic = null;

    boolean ipv6Address(boolean ipv6Address) {
        this.ipv6Address = ipv6Address;
        return ipv6Address;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10228().ipv6Address(ipv6Address);
    }
}
