import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_12497 {

    static SSLEngine ssle = null;

    static ByteBuffer[] appData = { null, null, null, null, null, null, null, null, null, null };

    static int offset = 2;

    static int len = 0;

    static ByteBuffer netData = null;

    SSLEngine tryOutOfBounds(SSLEngine ssle, ByteBuffer[] appData, int offset, int len, ByteBuffer netData) throws Exception {
        try {
            ssle.wrap(appData, offset, len, netData);
            throw new Exception();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught right exception");
        }
        try {
            ssle.unwrap(netData, appData, offset, len);
            throw new Exception();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught right exception");
        }
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12497().tryOutOfBounds(ssle, appData, offset, len, netData);
    }
}
