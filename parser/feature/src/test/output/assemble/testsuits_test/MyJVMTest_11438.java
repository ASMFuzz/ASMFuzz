import java.util.Arrays;

public class MyJVMTest_11438 {

    static double[] array = { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    double[] reset(double[] array) {
        if (null == array) {
            array = new double[3];
        }
        array[0] = 1.1;
        array[1] = 2.2;
        array[2] = 3.3;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11438().reset(array)));
    }
}
