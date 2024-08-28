import java.util.*;
import java.io.*;

public class MyJVMTest_13740 {

    static byte[] chunk = { 13, 6, 35, -26, -78, -66, 17, 110, 109, -64 };

    static Random rnd = new Random();

    byte[] touchPages(byte[] chunk) {
        final int pageSize = 4096;
        for (int i = 0; i < chunk.length; i += pageSize) {
            chunk[i] = (byte) rnd.nextInt();
        }
        return chunk;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13740().touchPages(chunk);
    }
}
