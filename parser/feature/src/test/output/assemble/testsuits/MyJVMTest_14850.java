import java.util.*;
import java.net.*;

public class MyJVMTest_14850 {

    static List<SocketAddress> sendToGroups = new ArrayList<SocketAddress>();

    boolean hasIPv6() throws Exception {
        List<NetworkInterface> nics = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface nic : nics) {
            if (!nic.isLoopback()) {
                List<InetAddress> addrs = Collections.list(nic.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (addr instanceof Inet6Address) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14850().hasIPv6());
    }
}
