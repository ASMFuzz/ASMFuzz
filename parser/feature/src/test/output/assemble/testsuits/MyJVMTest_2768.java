import java.io.*;

public class MyJVMTest_2768 {

    void testInt() throws IOException {
        File fh = new File(System.getProperty("test.dir", "."), "x.ReadWriteGenerated");
        RandomAccessFile f = new RandomAccessFile(fh, "rw");
        for (int i = 0; i < 10000; i++) {
            f.writeInt((short) i);
        }
        f.writeInt(Integer.MAX_VALUE);
        f.close();
        f = new RandomAccessFile(fh, "r");
        for (int i = 0; i < 10000; i++) {
            int r = f.readInt();
            if (r != i) {
                System.err.println("An error occurred. Read:" + r + " i:" + i);
                throw new IOException("Bad read from a writeInt");
            }
        }
        int rmax = f.readInt();
        if (rmax != Integer.MAX_VALUE) {
            System.err.println("An error occurred. Read:" + rmax);
            throw new IOException("Bad read from a writeInt");
        }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2768().testInt();
    }
}
