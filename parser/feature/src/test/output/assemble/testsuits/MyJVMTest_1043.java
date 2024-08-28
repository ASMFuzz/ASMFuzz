import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_1043 {

    static SSLServerSocket sslServerSocket = null;

    static Exception exception = null;

    void run() {
        try {
            SSLSocket sslsocket = null;
            while (true) {
                sslsocket = (SSLSocket) sslServerSocket.accept();
                DataInputStream in = new DataInputStream(sslsocket.getInputStream());
                DataOutputStream out = new DataOutputStream(sslsocket.getOutputStream());
                String string;
                while ((string = in.readUTF()) != null) {
                    out.writeUTF(string);
                    out.flush();
                }
            }
        } catch (Exception e) {
            exception = e;
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1043().run();
    }
}
