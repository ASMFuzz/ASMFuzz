import java.io.*;

public class MyJVMTest_4422 {

    void testShort() throws IOException {
        File fh = new File(System.getProperty("test.dir", "."), "x.ReadWriteGenerated");
        RandomAccessFile f = new RandomAccessFile(fh, "rw");
        for (int i = 0; i < 10000; i++) {
            f.writeShort((short) i);
        }
        f.writeShort((short) 65535);
        f.close();
        f = new RandomAccessFile(fh, "r");
        for (int i = 0; i < 10000; i++) {
            short r = f.readShort();
            if (r != ((short) i)) {
                System.err.println("An error occurred. Read:" + r + " i:" + ((short) i));
                throw new IOException("Bad read from a writeShort");
            }
        }
        short rmax = f.readShort();
        if (rmax != ((short) 65535)) {
            System.err.println("An error occurred. Read:" + rmax);
            throw new IOException("Bad read from a writeShort");
        }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4422().testShort();
    }
}
