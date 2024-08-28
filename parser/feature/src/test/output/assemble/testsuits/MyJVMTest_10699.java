import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.interfaces.*;

public class MyJVMTest_10699 {

    static SSLContext sslc = null;

    static SSLEngine ssle1 = null;

    static SSLEngine ssle2 = null;

    void createSSLEngines() throws Exception {
        ssle1 = sslc.createSSLEngine("client", 1);
        ssle1.setUseClientMode(true);
        ssle2 = sslc.createSSLEngine("server", 2);
        ssle2.setUseClientMode(false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10699().createSSLEngines();
    }
}
