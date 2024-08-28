import java.io.*;
import java.nio.channels.*;
import java.nio.*;

public class MyJVMTest_17768 {

    static boolean shared = false;

    static boolean trylock = false;

    FileChannel test2(boolean shared, boolean trylock) throws Exception {
        File testFile = File.createTempFile("test2", null);
        FileOutputStream fis = new FileOutputStream(testFile);
        FileChannel fc = fis.getChannel();
        FileLock fl = null;
        try {
            if (trylock)
                fl = fc.tryLock(0, fc.size(), shared);
            else
                fl = fc.lock(0, fc.size(), shared);
            if (shared)
                throw new RuntimeException("No exception thrown for test2");
        } catch (NonReadableChannelException e) {
            if (!shared)
                throw new RuntimeException("Exception thrown incorrectly for test2");
        } finally {
            if (fl != null)
                fl.release();
            fc.close();
            testFile.delete();
        }
        return fc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17768().test2(shared, trylock);
    }
}
