import java.util.*;
import java.io.*;

public class MyJVMTest_8153 {

    static int length = 3;

    int nextInt() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Integer.MIN_VALUE;
            case 2:
                return Integer.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return rnd.nextInt(20) - 10;
            default:
                return rnd.nextInt();
        }
    }

    static Random rnd = new Random();

    int[] intArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextInt();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8153().intArray(length)));
    }
}
