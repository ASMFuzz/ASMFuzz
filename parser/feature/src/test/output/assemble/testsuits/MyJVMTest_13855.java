import java.net.*;
import java.util.*;

public class MyJVMTest_13855 {

    static boolean ipv4Address = false;

    static NetworkInterface nic = null;

    boolean ipv4Address(boolean ipv4Address) {
        this.ipv4Address = ipv4Address;
        return ipv4Address;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13855().ipv4Address(ipv4Address);
    }
}
