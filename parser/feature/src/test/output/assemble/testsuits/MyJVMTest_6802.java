import javax.net.ssl.*;
import java.util.*;
import java.security.*;
import static javax.net.ssl.SSLEngineResult.HandshakeStatus.*;

public class MyJVMTest_6802 {

    static SSLEngine engine = null;

    static SSLEngineResult.HandshakeStatus expectedHSStat = null;

    static boolean expectedInboundDone = false;

    static boolean expectedOutboundDone = false;

    SSLEngine checkEngineState(SSLEngine engine, SSLEngineResult.HandshakeStatus expectedHSStat, boolean expectedInboundDone, boolean expectedOutboundDone) {
        if (engine.getHandshakeStatus() != expectedHSStat || engine.isInboundDone() != expectedInboundDone || engine.isOutboundDone() != expectedOutboundDone) {
            throw new RuntimeException("Error: engine not in expected state\n" + "Expected: state = " + expectedHSStat + ", inDone = " + expectedInboundDone + ", outDone = " + expectedOutboundDone + "\n" + "Actual: state = " + engine.getHandshakeStatus() + ", inDone = " + engine.isInboundDone() + ", outDone = " + engine.isOutboundDone());
        } else {
            System.out.println((engine.getUseClientMode() ? "Client" : "Server") + " handshake status: " + engine.getHandshakeStatus() + ", inDone = " + engine.isInboundDone() + ", outDone = " + engine.isOutboundDone());
        }
        return engine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6802().checkEngineState(engine, expectedHSStat, expectedInboundDone, expectedOutboundDone);
    }
}
