import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_8897 {

    static SSLSocket sslSocket = null;

    void shutdownInput(SSLSocket sslSocket) throws IOException {
        try {
            sslSocket.shutdownInput();
        } catch (SSLException e) {
            if (!e.getMessage().contains("closing inbound before receiving peer's close_notify")) {
                throw new RuntimeException("expected different exception " + "message. " + e.getMessage());
            }
        }
        if (!sslSocket.getSession().isValid()) {
            throw new RuntimeException("expected session to remain valid");
        }
    }

    static boolean separateServerThread = true;

    static String socketCloseType = "b+1^3?wcJ\\";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    SSLSocket closeConnection(SSLSocket sslSocket) throws IOException {
        if ("shutdownInput".equals(socketCloseType)) {
            shutdownInput(sslSocket);
            sslSocket.shutdownInput();
            sslSocket.shutdownOutput();
        } else if ("shutdownOutput".equals(socketCloseType)) {
            sslSocket.shutdownOutput();
            sslSocket.shutdownOutput();
            shutdownInput(sslSocket);
        } else {
            sslSocket.close();
        }
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8897().closeConnection(sslSocket);
    }
}
