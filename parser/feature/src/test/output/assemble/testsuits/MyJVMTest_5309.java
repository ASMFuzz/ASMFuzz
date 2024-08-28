import java.io.*;
import java.net.*;

public class MyJVMTest_5309 {

    static int port = 9;

    Socket doClientSide(int port) throws Exception {
        Socket socket = new Socket("localhost", port);
        InputStream is = socket.getInputStream();
        is.read();
        socket.close();
        is.read();
        return socket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5309().doClientSide(port);
    }
}
