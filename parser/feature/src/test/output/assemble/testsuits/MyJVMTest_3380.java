import javax.net.ssl.*;
import java.util.*;
import java.security.*;
import static javax.net.ssl.SSLEngineResult.HandshakeStatus.*;

public class MyJVMTest_3380 {

    static Status resultParam1 = null;

    static HandshakeStatus resultParam2 = null;

    static int resultParam3 = 764;

    static int resultParam4 = 335;

    static SSLEngineResult result = new SSLEngineResult(resultParam1, resultParam2, resultParam3, resultParam4);

    static SSLEngine engine = null;

    SSLEngine runDelegatedTasks(SSLEngineResult result, SSLEngine engine) throws Exception {
        if (result.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            Runnable runnable;
            while ((runnable = engine.getDelegatedTask()) != null) {
                System.out.println("\trunning delegated task...");
                runnable.run();
            }
            SSLEngineResult.HandshakeStatus hsStatus = engine.getHandshakeStatus();
            if (hsStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                throw new Exception("handshake shouldn't need additional tasks");
            }
            System.out.println("\tnew HandshakeStatus: " + hsStatus);
        }
        return engine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3380().runDelegatedTasks(result, engine);
    }
}
