import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_10597 {

    static SSLSessionContext sessCtx = null;

    static int nConn = 7;

    static boolean separateServerThread = true;

    static int MAX_ACTIVE_CONNECTIONS = 4;

    static int[] serverPorts = new int[] { 0, 0, 0, 0 };

    static SSLSocketFactory sslsf = null;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    int checkCachedSessions(SSLSessionContext sessCtx, int nConn) throws Exception {
        int nSessions = 0;
        Enumeration e = sessCtx.getIds();
        int cacheSize = sessCtx.getSessionCacheSize();
        SSLSession sess;
        while (e.hasMoreElements()) {
            sess = sessCtx.getSession((byte[]) e.nextElement());
            long lastAccessedTime = sess.getLastAccessedTime();
            System.out.println(sess + "       " + new Date(lastAccessedTime));
            nSessions++;
        }
        System.out.println("--------------------------------------------" + "----------------------------");
        if ((cacheSize > 0) && (nSessions > cacheSize)) {
            for (int conn = nConn; conn < MAX_ACTIVE_CONNECTIONS; conn++) {
                SSLSocket s = (SSLSocket) sslsf.createSocket("localhost", serverPorts[conn % (serverPorts.length)]);
                s.close();
            }
            throw new Exception("Session cache size test failed," + " current cache size: " + cacheSize + " #sessions cached: " + nSessions);
        }
        return nSessions;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10597().checkCachedSessions(sessCtx, nConn);
    }
}
