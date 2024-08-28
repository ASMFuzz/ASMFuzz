import java.util.*;
import java.io.*;

public class MyJVMTest_7165 {

    static int length = 0;

    float nextFloat() {
        switch(rnd.nextInt(20)) {
            case 0:
                return 0;
            case 1:
                return -0.0f;
            case 2:
                return Float.MIN_VALUE;
            case 3:
                return Float.MAX_VALUE;
            case 4:
                return Float.NaN;
            case 5:
                return Float.NEGATIVE_INFINITY;
            case 6:
                return Float.POSITIVE_INFINITY;
            case 7:
            case 8:
            case 9:
                return (rnd.nextInt(20) - 10);
            default:
                return rnd.nextFloat();
        }
    }

    static Random rnd = new Random();

    float[] floatArray(int length) {
        float[] result = new float[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextFloat();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7165().floatArray(length)));
    }
}
