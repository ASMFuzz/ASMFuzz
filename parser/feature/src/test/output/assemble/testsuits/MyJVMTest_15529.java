import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_15529 {

    static byte[] p1Param1 = { -41, 11, 60, 127, 0, 126, 108, 100, -15, -116 };

    static int p1Param2 = 748;

    static InetAddress p1Param3Param1 = null;

    static int p1Param3Param2 = 690;

    static SocketAddress p1Param3 = new InetSocketAddress(p1Param3Param1, p1Param3Param2);

    static DatagramPacket p1 = new DatagramPacket(p1Param1, p1Param2, p1Param3);

    static byte[] p2Param1 = { -27, 19, 59, 41, 73, 12, 106, 103, -20, -76 };

    static int p2Param2 = 511;

    static InetAddress p2Param3 = null;

    static int p2Param4 = 680;

    static DatagramPacket p2 = new DatagramPacket(p2Param1, p2Param2, p2Param3, p2Param4);

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = 9223372036854775807L;

    static String osname = ">7lsLaA@yI";

    DatagramPacket comparePackets(DatagramPacket p1, DatagramPacket p2) throws Exception {
        byte[] b1 = p1.getData();
        byte[] b2 = p2.getData();
        int len = p1.getLength() > p2.getLength() ? p2.getLength() : p1.getLength();
        for (int i = 0; i < len; i++) {
            if (b1[i] != b2[i]) {
                throw new Exception("packets not the same");
            }
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15529().comparePackets(p1, p2);
    }
}
