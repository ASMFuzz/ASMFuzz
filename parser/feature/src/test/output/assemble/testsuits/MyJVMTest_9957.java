import java.util.Arrays;

public class MyJVMTest_9957 {

    static int dataSize = -1596167068;

    double[] getTestArray_double(int dataSize) {
        double[] result = new double[dataSize / 8];
        for (int i = 0; i < result.length; i++) {
            result[i] = (double) i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9957().getTestArray_double(dataSize)));
    }
}
