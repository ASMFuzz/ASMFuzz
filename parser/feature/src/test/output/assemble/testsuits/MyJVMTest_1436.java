import java.util.*;
import java.io.*;

public class MyJVMTest_1436 {

    static int length = 0;

    double nextDouble() {
        switch(rnd.nextInt(20)) {
            case 0:
                return 0;
            case 1:
                return -0.0;
            case 2:
                return Double.MIN_VALUE;
            case 3:
                return Double.MAX_VALUE;
            case 4:
                return Double.NaN;
            case 5:
                return Double.NEGATIVE_INFINITY;
            case 6:
                return Double.POSITIVE_INFINITY;
            case 7:
            case 8:
            case 9:
                return (rnd.nextInt(20) - 10);
            default:
                return rnd.nextDouble();
        }
    }

    static Random rnd = new Random();

    double[] doubleArray(int length) {
        double[] result = new double[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextDouble();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1436().doubleArray(length)));
    }
}
