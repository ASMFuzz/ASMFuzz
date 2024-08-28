import java.util.*;
import java.net.*;

public class MyJVMTest_9680 {

    static List<SocketAddress> sendToGroups = new ArrayList<SocketAddress>();

    static boolean stop = false;

    void run() {
        byte[] buf = "hello world".getBytes();
        List<DatagramPacket> packets = new ArrayList<DatagramPacket>();
        try {
            for (SocketAddress group : sendToGroups) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group);
                packets.add(packet);
            }
            MulticastSocket msock = new MulticastSocket();
            msock.setLoopbackMode(true);
            while (!stop) {
                for (DatagramPacket packet : packets) {
                    msock.send(packet);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9680().run();
    }
}
