import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_2898 {

    static SSLEngine ssle = null;

    static ByteBuffer[] appData = { null, null, null, null, null, null, null, null, null, null };

    static int offset = -1702706705;

    static int len = 8;

    static ByteBuffer netData = null;

    SSLEngine tryNullArrayLen(SSLEngine ssle, ByteBuffer[] appData, int offset, int len, ByteBuffer netData) throws Exception {
        try {
            ssle.wrap(appData, offset, len, netData);
            throw new Exception();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught right exception");
        }
        try {
            ssle.unwrap(netData, appData, offset, len);
            throw new Exception();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught right exception");
        }
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2898().tryNullArrayLen(ssle, appData, offset, len, netData);
    }
}
