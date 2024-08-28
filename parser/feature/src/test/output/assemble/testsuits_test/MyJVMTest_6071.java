import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_6071 {

    static byte[] p1Param1 = { -63, 72, -18, -113, 121, -85, 74, -60, 93, 10 };

    static int p1Param2 = 939;

    static int p1Param3 = 958;

    static DatagramPacket p1 = new DatagramPacket(p1Param1, p1Param2, p1Param3);

    static byte[] p2Param1 = { -65, 0, 45, 42, -44, -124, -89, 21, -50, 2 };

    static int p2Param2 = 311;

    static DatagramPacket p2 = new DatagramPacket(p2Param1, p2Param2);

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = -9223372036854775808L;

    static String osname = "FV1tHuJ>=p";

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
        new MyJVMTest_6071().comparePackets(p1, p2);
    }
}
