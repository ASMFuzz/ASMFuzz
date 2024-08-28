import java.io.*;
import java.nio.channels.FileChannel;

public class MyJVMTest_5721 {

    void transferFileToTrustedChannel() throws Exception {
        long remainingBytes = in.size();
        long size = remainingBytes;
        FileOutputStream fos = new FileOutputStream(outFile);
        FileChannel out = fos.getChannel();
        while (remainingBytes > 0) {
            long bytesTransferred = in.transferTo(size - remainingBytes, CHUNK_SIZE, out);
            if (bytesTransferred >= 0)
                remainingBytes -= bytesTransferred;
            else
                throw new Exception("transfer failed");
        }
        out.close();
    }

    static File file = null;

    static File outFile = null;

    static FileChannel in = null;

    static int CHUNK_SIZE = 1024 * 9;

    void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            transferFileToTrustedChannel();
            System.gc();
            System.err.println("Transferred file...");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5721().test2();
    }
}
