import java.io.*;

public class MyJVMTest_15500 {

    static BufferedInputStream myStream = null;

    static ByteArrayOutputStream bout = null;

    void run() {
        byte[] buf = new byte[100];
        try {
            int length = this.myStream.read(buf);
            while (length >= 0) {
                System.out.write(buf, 0, length);
                bout.write(buf, 0, length);
                length = this.myStream.read(buf);
            }
        } catch (IOException e) {
            System.out.println("------------------- BEGIN bogus output from test? ----------------");
            e.printStackTrace();
            System.out.println("------------------- END bogus output from test? ----------------");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15500().run();
    }
}
