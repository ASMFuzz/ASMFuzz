import java.util.*;
import java.io.*;

public class MyJVMTest_9606 {

    static int length = 2;

    short nextShort() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Short.MIN_VALUE;
            case 2:
                return Short.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return (short) (rnd.nextInt(20) - 10);
            default:
                return (short) rnd.nextInt();
        }
    }

    static Random rnd = new Random();

    short[] shortArray(int length) {
        short[] result = new short[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextShort();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9606().shortArray(length)));
    }
}
