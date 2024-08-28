import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_13306 {

    static SSLEngine ssle = null;

    static SocketChannel sc = null;

    static ByteBuffer additional = null;

    ByteBuffer enlargeBuffer(ByteBuffer buffer, int size) {
        ByteBuffer bb = ByteBuffer.allocate(size);
        buffer.flip();
        bb.put(buffer);
        return bb;
    }

    static String pathToStores = "o$F;sXo{.6";

    SSLEngine handshaking(SSLEngine ssle, SocketChannel sc, ByteBuffer additional) throws Exception {
        int appBufferMax = ssle.getSession().getApplicationBufferSize();
        int netBufferMax = ssle.getSession().getPacketBufferSize();
        ByteBuffer localAppData = ByteBuffer.allocate(appBufferMax / 10);
        ByteBuffer peerAppData = ByteBuffer.allocate(appBufferMax / 10);
        ByteBuffer localNetData = ByteBuffer.allocate(netBufferMax / 10);
        ByteBuffer peerNetData = ByteBuffer.allocate(netBufferMax / 10);
        ssle.beginHandshake();
        SSLEngineResult.HandshakeStatus hs = ssle.getHandshakeStatus();
        byte[] buffer = new byte[0xFF];
        boolean underflow = false;
        do {
            switch(hs) {
                case NEED_UNWRAP:
                    if (peerNetData.position() == 0) {
                        if (additional != null && additional.hasRemaining()) {
                            do {
                                int len = Math.min(buffer.length, peerNetData.remaining());
                                len = Math.min(len, additional.remaining());
                                if (len != 0) {
                                    additional.get(buffer, 0, len);
                                    peerNetData.put(buffer, 0, len);
                                }
                            } while (peerNetData.remaining() > 0 && additional.hasRemaining());
                        } else {
                            if (sc.read(peerNetData) < 0) {
                                ssle.closeInbound();
                                return;
                            }
                        }
                    }
                    if (underflow) {
                        if (sc.read(peerNetData) < 0) {
                            ssle.closeInbound();
                            return;
                        }
                        underflow = false;
                    }
                    peerNetData.flip();
                    SSLEngineResult res = ssle.unwrap(peerNetData, peerAppData);
                    peerNetData.compact();
                    hs = res.getHandshakeStatus();
                    switch(res.getStatus()) {
                        case OK:
                            break;
                        case BUFFER_UNDERFLOW:
                            int size = ssle.getSession().getPacketBufferSize();
                            if (size > peerNetData.capacity()) {
                                System.out.println("resize source buffer upto " + size + " bytes for BUFFER_UNDERFLOW");
                                peerNetData = enlargeBuffer(peerNetData, size);
                            }
                            underflow = true;
                            break;
                        case BUFFER_OVERFLOW:
                            size = ssle.getSession().getApplicationBufferSize();
                            if (size > peerAppData.capacity()) {
                                System.out.println("resize destination buffer upto " + size + " bytes for BUFFER_OVERFLOW");
                                peerAppData = enlargeBuffer(peerAppData, size);
                            }
                            break;
                        default:
                            throw new IOException("Received invalid" + res.getStatus() + "during initial handshaking");
                    }
                    break;
                case NEED_WRAP:
                    localNetData.clear();
                    res = ssle.wrap(localAppData, localNetData);
                    hs = res.getHandshakeStatus();
                    switch(res.getStatus()) {
                        case OK:
                            localNetData.flip();
                            while (localNetData.hasRemaining()) {
                                if (sc.write(localNetData) < 0) {
                                    throw new IOException("Unable write to socket channel");
                                }
                            }
                            break;
                        case BUFFER_OVERFLOW:
                            int size = ssle.getSession().getPacketBufferSize();
                            if (size > localNetData.capacity()) {
                                System.out.println("resize destination buffer upto " + size + " bytes for BUFFER_OVERFLOW");
                                localNetData = enlargeBuffer(localNetData, size);
                            }
                            break;
                        default:
                            throw new IOException("Received invalid" + res.getStatus() + "during initial handshaking");
                    }
                    break;
                case NEED_TASK:
                    Runnable runnable;
                    while ((runnable = ssle.getDelegatedTask()) != null) {
                        runnable.run();
                    }
                    hs = ssle.getHandshakeStatus();
                    break;
                default:
            }
        } while (hs != SSLEngineResult.HandshakeStatus.FINISHED && hs != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13306().handshaking(ssle, sc, additional);
    }
}
