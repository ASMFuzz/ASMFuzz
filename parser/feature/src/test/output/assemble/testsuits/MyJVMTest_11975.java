import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_11975 {

    static DatagramChannel client = null;

    static DatagramChannel server = null;

    static InetSocketAddress isa = null;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11975().setup();
    }
}
