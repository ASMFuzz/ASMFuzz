import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.interfaces.*;

public class MyJVMTest_11485 {

    static SSLEngine e = null;

    static SSLContext sslc = null;

    boolean isHandshaking(SSLEngine e) {
        return (e.getHandshakeStatus() != HandshakeStatus.NOT_HANDSHAKING);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11485().isHandshaking(e));
    }
}
