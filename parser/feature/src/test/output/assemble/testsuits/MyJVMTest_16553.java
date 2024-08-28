import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_16553 {

    static SSLSocket socket = null;

    static SSLServerSocket ss = null;

    void run() {
        try {
            byte[] ba = new byte[1024];
            for (int i = 0; i < ba.length; i++) ba[i] = 0x7A;
            OutputStream os = socket.getOutputStream();
            int count = 0;
            while (true) {
                count += ba.length;
                System.out.println(count + " bytes to be written");
                os.write(ba);
                System.out.println(count + " bytes written");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16553().run();
    }
}
