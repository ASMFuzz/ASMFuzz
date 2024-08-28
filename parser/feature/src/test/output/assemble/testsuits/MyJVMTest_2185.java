import java.util.Arrays;

public class MyJVMTest_2185 {

    static double[] array = { Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0.009916247630578523, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.40632778255229385 };

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
        System.out.println(Arrays.asList(new MyJVMTest_2185().reset(array)));
    }
}
