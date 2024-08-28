import java.io.*;
import java.nio.channels.*;
import java.nio.*;

public class MyJVMTest_7908 {

    static boolean shared = false;

    static boolean trylock = true;

    FileChannel test1(boolean shared, boolean trylock) throws Exception {
        File testFile = File.createTempFile("test1", null);
        FileInputStream fis = new FileInputStream(testFile);
        FileChannel fc = fis.getChannel();
        FileLock fl = null;
        try {
            if (trylock)
                fl = fc.tryLock(0, fc.size(), shared);
            else
                fl = fc.lock(0, fc.size(), shared);
            if (!shared)
                throw new RuntimeException("No exception thrown for test1");
        } catch (NonWritableChannelException e) {
            if (shared)
                throw new RuntimeException("Exception thrown for wrong case test1");
        } finally {
            if (fl != null)
                fl.release();
            fc.close();
            testFile.delete();
        }
        return fc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7908().test1(shared, trylock);
    }
}
