import java.util.*;
import java.io.*;

public class MyJVMTest_1762 {

    static int length = 0;

    long nextLong() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Long.MIN_VALUE;
            case 2:
                return Long.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return (long) (rnd.nextInt(20) - 10);
            default:
                return rnd.nextLong();
        }
    }

    static Random rnd = new Random();

    long[] longArray(int length) {
        long[] result = new long[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextLong();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1762().longArray(length)));
    }
}
