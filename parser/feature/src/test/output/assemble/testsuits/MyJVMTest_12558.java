import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_12558 {

    static SSLEngine ssle = null;

    static ByteBuffer[] appBB = { null, null, null, null, null, null, null, null, null, null };

    static ByteBuffer smallNetBB = null;

    static ByteBuffer[] smallAppBB = { null, null, null, null, null, null, null, null, null, null };

    static ByteBuffer netBB = null;

    ByteBuffer[] trySmallBufsArray(SSLEngine ssle, ByteBuffer[] appBB, ByteBuffer smallNetBB, ByteBuffer[] smallAppBB, ByteBuffer netBB) throws Exception {
        SSLEngineResult res = ssle.wrap(appBB, 0, appBB.length, smallNetBB);
        if (res.getStatus() != Status.BUFFER_OVERFLOW) {
            throw new Exception();
        }
        return appBB;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12558().trySmallBufsArray(ssle, appBB, smallNetBB, smallAppBB, netBB);
    }
}
