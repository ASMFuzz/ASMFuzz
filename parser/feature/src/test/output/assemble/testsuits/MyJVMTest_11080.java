import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_11080 {

    static SSLEngine ssle = null;

    static ByteBuffer[] appData = { null, null, null, null, null, null, null, null, null, null };

    static ByteBuffer netData = null;

    SSLEngine tryNullArray(SSLEngine ssle, ByteBuffer[] appData, ByteBuffer netData) throws Exception {
        try {
            ssle.wrap(appData, netData);
            throw new Exception();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught right exception");
        }
        try {
            ssle.unwrap(netData, appData);
            throw new Exception();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught right exception");
        }
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11080().tryNullArray(ssle, appData, netData);
    }
}
