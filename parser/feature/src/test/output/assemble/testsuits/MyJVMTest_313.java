import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_313 {

    static int sParam1Param1 = 110;

    static SocketAddress sParam1 = new InetSocketAddress(sParam1Param1);

    static DatagramSocket s = new DatagramSocket(sParam1);

    static int IPTOS_RELIABILITY = 0x4;

    static int failures = 0;

    DatagramSocket testDatagramSocket(DatagramSocket s) {
        try {
            s.setTrafficClass(IPTOS_RELIABILITY);
            int tc = s.getTrafficClass();
        } catch (Exception e) {
            failures++;
            System.err.println("testDatagramSocket failed: " + e);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_313().testDatagramSocket(s);
    }
}
