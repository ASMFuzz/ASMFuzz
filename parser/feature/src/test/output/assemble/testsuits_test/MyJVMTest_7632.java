import java.net.*;
import java.io.*;

public class MyJVMTest_7632 {

    static boolean readUntilEOF = false;

    ServerSocket testEOF(boolean readUntilEOF) throws IOException {
        System.out.println("testEOF, readUntilEOF: " + readUntilEOF);
        InetAddress addr = InetAddress.getLoopbackAddress();
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(addr, 0), 0);
        int port = ss.getLocalPort();
        try (Socket s = new Socket(addr, port)) {
            s.getOutputStream().write(0x42);
            s.shutdownOutput();
            try (Socket soc = ss.accept()) {
                ss.close();
                InputStream is = soc.getInputStream();
                int b = is.read();
                assert b == 0x42;
                assert !s.isClosed();
                if (readUntilEOF) {
                    b = is.read();
                    assert b == -1;
                }
                int a;
                for (int i = 0; i < 100; i++) {
                    a = is.available();
                    System.out.print(a + ", ");
                    if (a != 0)
                        throw new RuntimeException("Unexpected non-zero available: " + a);
                }
                assert !s.isClosed();
                assert is.read() == -1;
            }
        }
        System.out.println("\ncomplete");
        return ss;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7632().testEOF(readUntilEOF);
    }
}
