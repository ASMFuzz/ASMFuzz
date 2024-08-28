import java.io.*;
import java.nio.channels.*;
import java.nio.*;

public class MyJVMTest_12545 {

    static boolean shared = false;

    static boolean trylock = false;

    FileChannel test3(boolean shared, boolean trylock) throws Exception {
        File testFile = File.createTempFile("test3", null);
        RandomAccessFile fis = new RandomAccessFile(testFile, "rw");
        FileChannel fc = fis.getChannel();
        try {
            FileLock fl = null;
            if (trylock)
                fl = fc.tryLock(0, fc.size(), shared);
            else
                fl = fc.lock(0, fc.size(), shared);
            fl.release();
        } finally {
            fc.close();
            testFile.delete();
        }
        return fc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12545().test3(shared, trylock);
    }
}
