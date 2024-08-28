import java.io.*;

public class MyJVMTest_15952 {

    static byte[] b = { 71, 73, -52, 73, 59, -113, -106, -17, -101, -53 };

    static int off = 6;

    static int len = 6;

    void testInputStream() throws IOException {
        File f = new File(System.getProperty("test.src", "."), "ReadZero.java");
        InputStream is = new FileInputStream(f) {

            public int read(byte[] b, int off, int len) {
                System.out.println("FileInputStream.read");
                return 0;
            }
        };
        try {
            is.read(new byte[1], 0, 1);
            InputStreamReader isr = new InputStreamReader(is);
            try {
                int res = isr.read(new char[1], 0, 1);
            } catch (IOException x) {
                System.out.println("IOException caught");
                return;
            }
        } finally {
            is.close();
        }
        throw new RuntimeException("IOException not thrown");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15952().read(b, off, len));
    }
}
