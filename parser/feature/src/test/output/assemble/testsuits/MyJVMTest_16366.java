import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_16366 {

    static SSLEngine ssle = null;

    static ByteBuffer appBB = null;

    static ByteBuffer smallNetBB = null;

    static ByteBuffer smallAppBB = null;

    static ByteBuffer netBB = null;

    SSLEngine trySmallBufs(SSLEngine ssle, ByteBuffer appBB, ByteBuffer smallNetBB, ByteBuffer smallAppBB, ByteBuffer netBB) throws Exception {
        SSLEngineResult res = ssle.wrap(appBB, smallNetBB);
        if (res.getStatus() != Status.BUFFER_OVERFLOW) {
            throw new Exception();
        }
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16366().trySmallBufs(ssle, appBB, smallNetBB, smallAppBB, netBB);
    }
}
