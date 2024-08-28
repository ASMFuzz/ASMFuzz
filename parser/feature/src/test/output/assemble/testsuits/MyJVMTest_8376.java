import java.net.*;
import java.util.*;

public class MyJVMTest_8376 {

    static InetAddress addr = null;

    InetAddress testConnectedUDP(InetAddress addr) throws Exception {
        try {
            DatagramSocket s = new DatagramSocket(0, addr);
            DatagramSocket ss = new DatagramSocket(0, addr);
            System.out.print("\tconnect...");
            s.connect(ss.getLocalAddress(), ss.getLocalPort());
            System.out.print("disconnect...");
            s.disconnect();
            System.out.println("local addr: " + s.getLocalAddress());
            System.out.println("local port: " + s.getLocalPort());
            byte[] data = { 0, 1, 2 };
            DatagramPacket p = new DatagramPacket(data, data.length, s.getLocalAddress(), s.getLocalPort());
            s.setSoTimeout(10000);
            System.out.print("send...");
            s.send(p);
            System.out.print("recv...");
            s.receive(p);
            System.out.println("OK");
            ss.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return addr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8376().testConnectedUDP(addr);
    }
}
