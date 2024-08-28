import java.net.*;
import java.util.*;

public class MyJVMTest_9806 {

    boolean hasIPv6() throws Exception {
        List<NetworkInterface> nics = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface nic : nics) {
            List<InetAddress> addrs = Collections.list(nic.getInetAddresses());
            for (InetAddress addr : addrs) {
                if (addr instanceof Inet6Address)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9806().hasIPv6());
    }
}
