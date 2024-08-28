import java.lang.management.*;

public class MyJVMTest_12054 {

    static long size = -1116635141447534438L;

    long ensureValidSize(long size) {
        if (size < 0) {
            throw new RuntimeException("Invalid allocated bytes returned = " + size);
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12054().ensureValidSize(size);
    }
}
