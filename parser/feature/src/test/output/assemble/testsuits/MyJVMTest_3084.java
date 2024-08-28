import java.util.*;

public class MyJVMTest_3084 {

    void testFlipTime() {
        BitSet b1 = new BitSet();
        b1.set(1000);
        long startTime = System.currentTimeMillis();
        for (int x = 0; x < 100000; x++) {
            b1.flip(100, 900);
        }
        long endTime = System.currentTimeMillis();
        long total = endTime - startTime;
        System.out.println("Multiple word flip Time " + total);
        startTime = System.currentTimeMillis();
        for (int x = 0; x < 100000; x++) {
            b1.flip(2, 44);
        }
        endTime = System.currentTimeMillis();
        total = endTime - startTime;
        System.out.println("Single word flip Time " + total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3084().testFlipTime();
    }
}
