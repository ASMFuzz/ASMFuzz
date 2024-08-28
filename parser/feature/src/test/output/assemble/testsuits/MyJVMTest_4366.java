import java.util.*;
import java.io.*;

public class MyJVMTest_4366 {

    static byte[] chunk = { -64, -7, -110, -60, -33, -76, 64, 113, -122, 40 };

    static Random rnd = new Random();

    byte[] touchPages(byte[] chunk) {
        final int pageSize = 4096;
        for (int i = 0; i < chunk.length; i += pageSize) {
            chunk[i] = (byte) rnd.nextInt();
        }
        return chunk;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4366().touchPages(chunk);
    }
}
