import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_5844 {

    static SSLEngine ssle = null;

    void checkDone(SSLEngine ssle) throws Exception {
        if (!ssle.isInboundDone()) {
            throw new Exception("isInboundDone isn't done");
        }
        if (!ssle.isOutboundDone()) {
            throw new Exception("isOutboundDone isn't done");
        }
    }

    SSLEngine runTest2(SSLEngine ssle) throws Exception {
        ssle.closeOutbound();
        checkDone(ssle);
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5844().runTest2(ssle);
    }
}
