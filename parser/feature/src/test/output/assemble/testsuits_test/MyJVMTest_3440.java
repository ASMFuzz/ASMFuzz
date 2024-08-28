import java.nio.channels.*;
import java.net.*;
import java.io.*;

public class MyJVMTest_3440 {

    static int port = 0;

    static InputStream in = null;

    SocketChannel connect(int port) throws IOException {
        InetAddress lh = InetAddress.getLoopbackAddress();
        InetSocketAddress isa = new InetSocketAddress(lh, port);
        return SocketChannel.open(isa);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3440().connect(port));
    }
}
