import java.io.*;
import java.net.*;
import java.applet.Applet;

public class MyJVMTest_5895 {

    static byte[] pParam1 = { -8, 31, -85, 12, 122, -109, 111, 68, 25, -53 };

    static int pParam2 = 768;

    static int pParam3 = 449;

    static int pParam4Param1 = 304;

    static SocketAddress pParam4 = new InetSocketAddress(pParam4Param1);

    static DatagramPacket p = new DatagramPacket(pParam1, pParam2, pParam3, pParam4);

    int peekData(DatagramPacket p) throws IOException {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5895().peekData(p));
    }
}
