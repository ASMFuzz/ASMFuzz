import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_9958 {

    void test1() throws Exception {
        DatagramChannel sndChannel = DatagramChannel.open();
        sndChannel.socket().bind(null);
        InetAddress address = InetAddress.getLocalHost();
        if (address.isLoopbackAddress()) {
            address = InetAddress.getLoopbackAddress();
        }
        InetSocketAddress sender = new InetSocketAddress(address, sndChannel.socket().getLocalPort());
        DatagramChannel rcvChannel = DatagramChannel.open();
        rcvChannel.socket().bind(null);
        InetSocketAddress receiver = new InetSocketAddress(address, rcvChannel.socket().getLocalPort());
        rcvChannel.connect(sender);
        sndChannel.connect(receiver);
        ByteBuffer bb = ByteBuffer.allocate(256);
        bb.put("hello".getBytes());
        bb.flip();
        int sent = sndChannel.send(bb, receiver);
        bb.clear();
        rcvChannel.receive(bb);
        bb.flip();
        CharBuffer cb = Charset.forName("US-ASCII").newDecoder().decode(bb);
        if (!cb.toString().startsWith("h"))
            throw new RuntimeException("Test failed");
        rcvChannel.close();
        sndChannel.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9958().test1();
    }
}
