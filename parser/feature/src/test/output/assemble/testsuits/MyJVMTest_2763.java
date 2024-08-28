import java.lang.management.*;

public class MyJVMTest_2763 {

    static long size = 9223372036854775807L;

    long ensureValidSize(long size) {
        if (size < 0) {
            throw new RuntimeException("Invalid allocated bytes returned = " + size);
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2763().ensureValidSize(size);
    }
}
