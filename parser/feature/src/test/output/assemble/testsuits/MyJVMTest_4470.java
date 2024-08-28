import java.net.*;
import java.util.*;

public class MyJVMTest_4470 {

    static boolean ipv4Address = true;

    static NetworkInterface nic = null;

    boolean ipv4Address(boolean ipv4Address) {
        this.ipv4Address = ipv4Address;
        return ipv4Address;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4470().ipv4Address(ipv4Address);
    }
}
