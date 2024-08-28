import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_17446 {

    static SSLEngine ssle = null;

    static ByteBuffer appData = null;

    static ByteBuffer netData = null;

    SSLEngine tryNull(SSLEngine ssle, ByteBuffer appData, ByteBuffer netData) throws Exception {
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
        new MyJVMTest_17446().tryNull(ssle, appData, netData);
    }
}
