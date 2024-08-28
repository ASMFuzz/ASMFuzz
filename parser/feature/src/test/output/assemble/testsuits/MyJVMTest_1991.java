import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_1991 {

    static SSLEngine ssle = null;

    static SocketChannel sc = null;

    ByteBuffer enlargeBuffer(ByteBuffer buffer, int size) {
        ByteBuffer bb = ByteBuffer.allocate(size);
        buffer.flip();
        bb.put(buffer);
        return bb;
    }

    static String pathToStores = "5rSf;FR|*d";

    ByteBuffer deliver(SSLEngine ssle, SocketChannel sc) throws Exception {
        int appBufferMax = ssle.getSession().getApplicationBufferSize();
        int netBufferMax = ssle.getSession().getPacketBufferSize();
        int length = appBufferMax * (Integer.SIZE / 8);
        ByteBuffer localAppData = ByteBuffer.allocate(length);
        ByteBuffer localNetData = ByteBuffer.allocate(netBufferMax / 2);
        localAppData.putInt(length);
        for (int i = 1; i < appBufferMax; i++) {
            localAppData.putInt(i);
        }
        localAppData.flip();
        while (localAppData.hasRemaining()) {
            localNetData.clear();
            SSLEngineResult res = ssle.wrap(localAppData, localNetData);
            switch(res.getStatus()) {
                case OK:
                    localNetData.flip();
                    while (localNetData.hasRemaining()) {
                        if (sc.write(localNetData) < 0) {
                            throw new IOException("Unable write to socket channel");
                        }
                    }
                    if (res.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        Runnable runnable;
                        while ((runnable = ssle.getDelegatedTask()) != null) {
                            runnable.run();
                        }
                    }
                    if (res.bytesProduced() >= Short.MAX_VALUE) {
                        System.out.println("Generate a " + res.bytesProduced() + " bytes large packet ");
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
                    throw new IOException("Received invalid" + res.getStatus() + "during transfer application data");
            }
        }
        return localNetData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1991().deliver(ssle, sc);
    }
}
