import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_13689 {

    static int port = 9;

    static Exception e = null;

    void run() {
        try {
            DatagramSocket ds = new DatagramSocket();
            String dataString = "hello";
            byte[] data = dataString.getBytes();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(data, data.length, address, port);
            ds.send(dp);
            Thread.sleep(50);
            ds.send(dp);
        } catch (Exception ex) {
            e = ex;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13689().run();
    }
}
