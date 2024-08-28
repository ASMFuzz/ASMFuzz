import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_13783 {

    static SSLSocket eventParam1 = null;

    static SSLSession eventParam2 = null;

    static HandshakeCompletedEvent event = new HandshakeCompletedEvent(eventParam1, eventParam2);

    static byte handshakesCompleted = 0;

    static boolean separateServerThread = false;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    HandshakeCompletedEvent handshakeCompleted(HandshakeCompletedEvent event) {
        synchronized (this) {
            handshakesCompleted++;
            System.out.println("Session: " + event.getSession().toString());
            System.out.println("Seen handshake completed #" + handshakesCompleted);
        }
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13783().handshakeCompleted(event);
    }
}
