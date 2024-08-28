import java.net.*;
import java.util.*;

public class MyJVMTest_8224 {

    static boolean ipv6Address = false;

    static NetworkInterface nic = null;

    boolean ipv6Address() {
        return ipv6Address;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8224().ipv6Address());
    }
}
