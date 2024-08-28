import javax.crypto.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.*;

public class MyJVMTest_2951 {

    static SSLEngine ssle = null;

    SSLEngine checkDone(SSLEngine ssle) throws Exception {
        if (!ssle.isInboundDone()) {
            throw new Exception("isInboundDone isn't done");
        }
        if (!ssle.isOutboundDone()) {
            throw new Exception("isOutboundDone isn't done");
        }
        return ssle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2951().checkDone(ssle);
    }
}
