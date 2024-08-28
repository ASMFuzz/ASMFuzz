import java.net.*;
import java.io.*;

public class MyJVMTest_5562 {

    static boolean readUntilEOF = true;

    ServerSocket testIOEOnClosed(boolean readUntilEOF) throws IOException {
        System.out.println("testIOEOnClosed, readUntilEOF: " + readUntilEOF);
        InetAddress addr = InetAddress.getLoopbackAddress();
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(addr, 0), 0);
        int port = ss.getLocalPort();
        try (Socket s = new Socket(addr, port)) {
            s.getOutputStream().write(0x43);
            s.shutdownOutput();
            try (Socket soc = ss.accept()) {
                ss.close();
                InputStream is = soc.getInputStream();
                int b = is.read();
                assert b == 0x43;
                assert !s.isClosed();
                if (readUntilEOF) {
                    b = is.read();
                    assert b == -1;
                }
                is.close();
                try {
                    b = is.available();
                    throw new RuntimeException("UNEXPECTED successful read: " + b);
                } catch (IOException expected) {
                    System.out.println("caught expected IOException:" + expected);
                }
            }
        }
        System.out.println("\ncomplete");
        return ss;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5562().testIOEOnClosed(readUntilEOF);
    }
}
