import java.net.*;
import java.util.*;

public class MyJVMTest_897 {

    static boolean ipv4Address = false;

    static NetworkInterface nic = null;

    boolean ipv4Address() {
        return ipv4Address;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_897().ipv4Address());
    }
}
