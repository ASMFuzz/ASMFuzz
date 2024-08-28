import java.net.*;
import java.util.*;

public class MyJVMTest_14183 {

    static Object option = -1459918221;

    static Object testValue = 0;

    NetworkInterface getNetworkInterface() {
        try {
            Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
            while (nifs.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nifs.nextElement();
                if (ni.supportsMulticast()) {
                    return ni;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14183().getNetworkInterface());
    }
}
