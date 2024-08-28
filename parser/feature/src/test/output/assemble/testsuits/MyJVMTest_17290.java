import java.util.*;

public class MyJVMTest_17290 {

    static double[][] values = { { Double.MAX_VALUE, Double.NaN, 0.6965124134524406, 0.9334824785462729, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d }, { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.NaN, 0d, Double.NaN } };

    static double d = Double.NEGATIVE_INFINITY;

    static Random r = new Random(0);

    long m_pow(double[][] values) {
        double res = 0;
        long start = System.nanoTime();
        for (int i = 0; i < values.length; i++) {
            res += Math.pow(values[i][0], values[i][1]);
        }
        long stop = System.nanoTime();
        d = res;
        return (stop - start) / 1000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17290().m_pow(values));
    }
}
