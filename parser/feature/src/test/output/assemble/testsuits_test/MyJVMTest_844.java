import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_844 {

    static SSLEngine ssle = null;

    static SocketChannel sc = null;

    ByteBuffer enlargeBuffer(ByteBuffer buffer, int size) {
        ByteBuffer bb = ByteBuffer.allocate(size);
        buffer.flip();
        bb.put(buffer);
        return bb;
    }

    static String pathToStores = "O`&kJ:]'4h";

    ByteBuffer receive(SSLEngine ssle, SocketChannel sc) throws Exception {
        int appBufferMax = ssle.getSession().getApplicationBufferSize();
        int netBufferMax = ssle.getSession().getPacketBufferSize();
        ByteBuffer peerAppData = ByteBuffer.allocate(appBufferMax / 2);
        ByteBuffer peerNetData = ByteBuffer.allocate(netBufferMax / 2);
        int received = -1;
        boolean needToReadMore = true;
        while (received != 0) {
            if (needToReadMore) {
                if (ssle.isInboundDone() || sc.read(peerNetData) < 0) {
                    break;
                }
            }
            peerNetData.flip();
            SSLEngineResult res = ssle.unwrap(peerNetData, peerAppData);
            peerNetData.compact();
            switch(res.getStatus()) {
                case OK:
                    if (res.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        Runnable runnable;
                        while ((runnable = ssle.getDelegatedTask()) != null) {
                            runnable.run();
                        }
                    }
                    if (received < 0 && res.bytesProduced() < 4) {
                        break;
                    }
                    if (received < 0) {
                        received = peerAppData.getInt(0);
                    }
                    System.out.println("received " + peerAppData.position() + " bytes client application data");
                    System.out.println("\tcomsumed " + res.bytesConsumed() + " byes network data");
                    peerAppData.clear();
                    received -= res.bytesProduced();
                    if (res.bytesConsumed() >= Short.MAX_VALUE) {
                        System.out.println("Consumes a " + res.bytesConsumed() + " bytes large packet ");
                    }
                    needToReadMore = (peerNetData.position() > 0) ? false : true;
                    break;
                case BUFFER_OVERFLOW:
                    int size = ssle.getSession().getApplicationBufferSize();
                    if (size > peerAppData.capacity()) {
                        System.out.println("resize destination buffer upto " + size + " bytes for BUFFER_OVERFLOW");
                        peerAppData = enlargeBuffer(peerAppData, size);
                    }
                    break;
                case BUFFER_UNDERFLOW:
                    size = ssle.getSession().getPacketBufferSize();
                    if (size > peerNetData.capacity()) {
                        System.out.println("resize source buffer upto " + size + " bytes for BUFFER_UNDERFLOW");
                        peerNetData = enlargeBuffer(peerNetData, size);
                    }
                    needToReadMore = true;
                    break;
                default:
                    throw new IOException("Received invalid" + res.getStatus() + "during transfer application data");
            }
        }
        return peerNetData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_844().receive(ssle, sc);
    }
}
