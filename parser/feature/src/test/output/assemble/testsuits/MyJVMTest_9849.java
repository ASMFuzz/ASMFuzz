import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_9849 {

    void test() throws Exception {
        ServerSocketChannel ssc = null;
        SocketChannel sc = null;
        SocketChannel peer = null;
        try {
            ssc = ServerSocketChannel.open().bind(new InetSocketAddress(0));
            InetAddress lh = InetAddress.getLocalHost();
            sc = SocketChannel.open(new InetSocketAddress(lh, ssc.socket().getLocalPort()));
            peer = ssc.accept();
            int n = peer.write(ByteBuffer.wrap("Hello".getBytes()));
            assert n > 0;
            sc.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey key = sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            boolean done = false;
            int failCount = 0;
            while (!done) {
                int nSelected = selector.select();
                if (nSelected > 0) {
                    if (nSelected > 1)
                        throw new RuntimeException("More than one channel selected");
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        key = iterator.next();
                        iterator.remove();
                        if (key.isWritable()) {
                            failCount++;
                            if (failCount > 10)
                                throw new RuntimeException("Test failed");
                            Thread.sleep(250);
                        }
                        if (key.isReadable()) {
                            done = true;
                        }
                    }
                }
            }
        } finally {
            if (peer != null)
                peer.close();
            if (sc != null)
                sc.close();
            if (ssc != null)
                ssc.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9849().test();
    }
}
