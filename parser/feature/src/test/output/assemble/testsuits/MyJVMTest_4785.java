import java.net.*;
import java.util.*;

public class MyJVMTest_4785 {

    static Object option = 2;

    static Object testValue = -1927712752;

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
        System.out.println(new MyJVMTest_4785().getNetworkInterface());
    }
}
