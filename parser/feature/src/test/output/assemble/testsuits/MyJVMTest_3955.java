import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class MyJVMTest_3955 {

    static String INDENT = "\t\t\t\t";

    static ServerSocketChannel _listener = null;

    void run() {
        try {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(INDENT + "Listening on port " + _listener.socket().getLocalPort());
            ByteBuffer buf = ByteBuffer.allocate(5);
            Socket client = _listener.accept().socket();
            ;
            System.out.println(INDENT + "Accepted client");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            int n = in.read();
            System.out.println(INDENT + "Read byte " + n + "\n");
            System.out.println(INDENT + "2. Writing byte 2");
            out.write((byte) 2);
            n = in.read();
            System.out.println(INDENT + "Read byte " + n + "\n");
            n = in.read();
            System.out.println(INDENT + "Read byte " + (n < 0 ? "EOF" : Integer.toString(n)));
            System.out.println(INDENT + "Closing");
            client.close();
        } catch (IOException e) {
            System.out.println(INDENT + "Error accepting!");
        } finally {
            try {
                _listener.close();
            } catch (IOException ignore) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3955().run();
    }
}
