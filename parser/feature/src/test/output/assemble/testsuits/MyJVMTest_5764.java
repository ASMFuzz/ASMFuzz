import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_5764 {

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

    void test1() throws Exception {
        setup();
        server.send(outBuf, isa);
        server.receive(inBuf);
        client.close();
        outBuf.rewind();
        server.send(outBuf, isa);
        server.receive(inBuf);
        server.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5764().test1();
    }
}
