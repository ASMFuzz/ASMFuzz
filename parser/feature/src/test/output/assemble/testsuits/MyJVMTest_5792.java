import java.io.*;

public class MyJVMTest_5792 {

    void testChar() throws IOException {
        File fh = new File(System.getProperty("test.dir", "."), "x.ReadWriteGenerated");
        RandomAccessFile f = new RandomAccessFile(fh, "rw");
        for (int i = 0; i < 10000; i++) {
            f.writeChar((char) i);
        }
        f.close();
        f = new RandomAccessFile(fh, "r");
        for (int i = 0; i < 10000; i++) {
            char r = f.readChar();
            if (r != ((char) i)) {
                System.err.println("An error occurred. Read:" + r + " i:" + ((char) i));
                throw new IOException("Bad read from a writeChar");
            }
        }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5792().testChar();
    }
}
