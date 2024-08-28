import java.net.*;

public class MyJVMTest_12029 {

    static ServerSocket ss = null;

    static InetAddress addr = null;

    static int port = 6;

    void testBindNull() throws Exception {
        try (Socket soc = new Socket()) {
            soc.bind(null);
            if (!soc.isBound())
                throw new RuntimeException("should be bound after bind(null)");
            if (soc.getLocalPort() <= 0)
                throw new RuntimeException("bind(null) failed, local port: " + soc.getLocalPort());
            if (soc.getLocalAddress() == null)
                throw new RuntimeException("bind(null) failed, local address is null");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12029().testBindNull();
    }
}
