import java.io.*;
import java.net.*;
import java.applet.Applet;

public class MyJVMTest_15345 {

    static byte[] pParam1 = { -48, 117, 97, 48, -89, -38, 78, -101, -19, -25 };

    static int pParam2 = 650;

    static DatagramPacket p = new DatagramPacket(pParam1, pParam2);

    int peekData(DatagramPacket p) throws IOException {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15345().peekData(p));
    }
}
