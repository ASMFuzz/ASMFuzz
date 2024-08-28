import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_5053 {

    static Status resultParam1 = null;

    static HandshakeStatus resultParam2 = null;

    static int resultParam3 = 269;

    static int resultParam4 = 402;

    static SSLEngineResult result = new SSLEngineResult(resultParam1, resultParam2, resultParam3, resultParam4);

    static SSLEngine engine = null;

    SSLEngine runDelegatedTasks(SSLEngineResult result, SSLEngine engine) throws Exception {
        if (result.getHandshakeStatus() == HandshakeStatus.NEED_TASK) {
            Runnable runnable;
            while ((runnable = engine.getDelegatedTask()) != null) {
                System.out.println("\trunning delegated task...");
                runnable.run();
            }
            HandshakeStatus hsStatus = engine.getHandshakeStatus();
            if (hsStatus == HandshakeStatus.NEED_TASK) {
                throw new Exception("handshake shouldn't need additional tasks");
            }
            System.out.println("\tnew HandshakeStatus: " + hsStatus);
        }
        return engine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5053().runDelegatedTasks(result, engine);
    }
}
