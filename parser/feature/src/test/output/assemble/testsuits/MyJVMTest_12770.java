import java.nio.channels.*;
import java.net.*;
import java.io.*;

public class MyJVMTest_12770 {

    static int port = 7;

    static InputStream in = null;

    SocketChannel connect(int port) throws IOException {
        InetAddress lh = InetAddress.getLoopbackAddress();
        InetSocketAddress isa = new InetSocketAddress(lh, port);
        return SocketChannel.open(isa);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12770().connect(port));
    }
}
