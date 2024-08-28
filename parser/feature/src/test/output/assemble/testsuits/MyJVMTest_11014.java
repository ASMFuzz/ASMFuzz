import java.net.*;

public class MyJVMTest_11014 {

    static String[] msgs = { "Hello World", "Java", "Good Bye" };

    static int port = 0;

    static DatagramSocket ds = null;

    void run() {
        byte[] b = new byte[100];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        while (true) {
            try {
                ds.receive(dp);
                String reply = new String(dp.getData(), dp.getOffset(), dp.getLength());
                ds.send(new DatagramPacket(reply.getBytes(), reply.length(), dp.getAddress(), dp.getPort()));
                if (reply.equals(msgs[msgs.length - 1])) {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        ds.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11014().run();
    }
}
