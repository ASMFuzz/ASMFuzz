import java.net.*;
import java.util.*;

public class MyJVMTest_2940 {

    Inet6Address getLocalAddr() throws Exception {
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            NetworkInterface ifc = (NetworkInterface) e.nextElement();
            Enumeration addrs = ifc.getInetAddresses();
            while (addrs.hasMoreElements()) {
                InetAddress a = (InetAddress) addrs.nextElement();
                if (a instanceof Inet6Address) {
                    Inet6Address ia6 = (Inet6Address) a;
                    if (ia6.isLinkLocalAddress()) {
                        return ia6;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2940().getLocalAddr());
    }
}
