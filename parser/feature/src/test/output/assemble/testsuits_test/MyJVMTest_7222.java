import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_7222 {

    void setup() throws Exception {
        client = DatagramChannel.open();
        server = DatagramChannel.open();
        client.socket().bind((SocketAddress) null);
        server.socket().bind((SocketAddress) null);
        client.configureBlocking(false);
        server.configureBlocking(false);
        InetAddress address = InetAddress.getLocalHost();
        int port = client.socket().getLocalPort();
        isa = new InetSocketAddress(address, port);
    }

    static ByteBuffer outBuf = ByteBuffer.allocateDirect(100);

    static ByteBuffer inBuf = ByteBuffer.allocateDirect(100);

    static DatagramChannel client = null;

    static DatagramChannel server = null;

    static InetSocketAddress isa = null;

    void test2() throws Exception {
        setup();
        server.configureBlocking(true);
        server.connect(isa);
        server.configureBlocking(false);
        outBuf.rewind();
        server.write(outBuf);
        server.receive(inBuf);
        client.close();
        Thread.sleep(2000);
        outBuf.rewind();
        try {
            server.write(outBuf);
            Thread.sleep(2000);
            inBuf.clear();
            server.read(inBuf);
        } catch (PortUnreachableException pue) {
            System.err.println("received PUE");
        }
        server.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7222().test2();
    }
}
