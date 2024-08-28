import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_17361 {

    static SSLSession initSession = null;

    static SSLSession resSession = null;

    static String alg = "2+\"8p/Em*k";

    SSLSession checkResumedSession(SSLSession initSession, SSLSession resSession) throws Exception {
        StringBuilder diffLog = new StringBuilder();
        long initCt = initSession.getCreationTime();
        long resumeCt = resSession.getCreationTime();
        if (initCt != resumeCt) {
            diffLog.append("Session creation time is different. Initial: ").append(initCt).append(", Resumed: ").append(resumeCt).append("\n");
        }
        if (!Arrays.equals(initSession.getLocalCertificates(), resSession.getLocalCertificates())) {
            diffLog.append("Local certificate mismatch between initial " + "and resumed sessions\n");
        }
        if (!Arrays.equals(initSession.getPeerCertificates(), resSession.getPeerCertificates())) {
            diffLog.append("Peer certificate mismatch between initial " + "and resumed sessions\n");
        }
        if (initSession.getApplicationBufferSize() != resSession.getApplicationBufferSize()) {
            diffLog.append(String.format("App Buffer sizes differ: Init: %d, Res: %d\n", initSession.getApplicationBufferSize(), resSession.getApplicationBufferSize()));
        }
        if (initSession.getPacketBufferSize() != resSession.getPacketBufferSize()) {
            diffLog.append(String.format("Packet Buffer sizes differ: Init: %d, Res: %d\n", initSession.getPacketBufferSize(), resSession.getPacketBufferSize()));
        }
        if (!initSession.getCipherSuite().equals(resSession.getCipherSuite())) {
            diffLog.append(String.format("CipherSuite does not match - Init: %s, Res: %s\n", initSession.getCipherSuite(), resSession.getCipherSuite()));
        }
        if (!initSession.getPeerHost().equals(resSession.getPeerHost()) || initSession.getPeerPort() != resSession.getPeerPort()) {
            diffLog.append(String.format("Host/Port mismatch - Init: %s/%d, Res: %s/%d\n", initSession.getPeerHost(), initSession.getPeerPort(), resSession.getPeerHost(), resSession.getPeerPort()));
        }
        if (!initSession.getProtocol().equals(resSession.getProtocol())) {
            diffLog.append(String.format("Protocol mismatch - Init: %s, Res: %s\n", initSession.getProtocol(), resSession.getProtocol()));
        }
        if (diffLog.length() > 0) {
            throw new RuntimeException(diffLog.toString());
        }
        return initSession;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17361().checkResumedSession(initSession, resSession);
    }
}
