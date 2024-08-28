import java.util.Arrays;

public class MyJVMTest_778 {

    static int dataSize = 64378546;

    double[] getTestArray_double(int dataSize) {
        double[] result = new double[dataSize / 8];
        for (int i = 0; i < result.length; i++) {
            result[i] = (double) i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_778().getTestArray_double(dataSize)));
    }
}
