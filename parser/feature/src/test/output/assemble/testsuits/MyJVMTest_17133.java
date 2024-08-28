import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17133 {

    static ExtendedSSLSession session = null;

    static boolean separateServerThread = true;

    static String clientRequestedHostname = "www.example.com";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    List<SNIServerName> checkSNIInSession(ExtendedSSLSession session) throws Exception {
        List<SNIServerName> sessionSNI = session.getRequestedServerNames();
        if (sessionSNI.isEmpty()) {
            throw new Exception("unexpected empty request server name indication");
        }
        if (sessionSNI.size() != 1) {
            throw new Exception("unexpected request server name indication");
        }
        SNIServerName serverName = sessionSNI.get(0);
        if (!(serverName instanceof SNIHostName)) {
            throw new Exception("unexpected instance of request server name indication");
        }
        String hostname = ((SNIHostName) serverName).getAsciiName();
        if (!clientRequestedHostname.equalsIgnoreCase(hostname)) {
            throw new Exception("unexpected request server name indication value");
        }
        return sessionSNI;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17133().checkSNIInSession(session);
    }
}
