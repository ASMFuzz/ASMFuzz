import java.nio.channels.*;
import java.net.*;
import java.io.*;

public class MyJVMTest_4151 {

    static int port = -1547276717;

    SocketChannel connect(int port) throws IOException {
        InetAddress lh = InetAddress.getByName("127.0.0.1");
        InetSocketAddress isa = new InetSocketAddress(lh, port);
        return SocketChannel.open(isa);
    }

    static InputStream in = null;

    int child(int port) {
        try {
            connect(port).close();
        } catch (IOException x) {
            x.printStackTrace();
            return;
        }
        for (; ; ) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException x) {
            }
        }
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4151().child(port);
    }
}
