import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_5158 {

    static SSLEngine engine = null;

    boolean isEngineClosed(SSLEngine engine) {
        return (engine.isOutboundDone() && engine.isInboundDone());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5158().isEngineClosed(engine));
    }
}
