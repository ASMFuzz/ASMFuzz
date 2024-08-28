import java.net.*;

public class MyJVMTest_3703 {

    static long timeWritten = 9223372036854775807L;

    static InetAddress addr = null;

    static int port = 2;

    void run() {
        try {
            byte[] b = new byte[12];
            Socket s = new Socket(addr, port);
            Thread.yield();
            timeWritten = System.currentTimeMillis();
            s.getOutputStream().write(b, 0, 12);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3703().run();
    }
}
